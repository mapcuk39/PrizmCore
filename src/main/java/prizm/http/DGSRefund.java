/******************************************************************************
 * Copyright © 2013-2016 The Nxt Core Developers.                             *
 *                                                                            *
 * See the AUTHORS.txt, DEVELOPER-AGREEMENT.txt and LICENSE.txt files at      *
 * the top-level directory of this distribution for the individual copyright  *
 * holder information and the developer policies on copyright and licensing.  *
 *                                                                            *
 * Unless otherwise agreed in a custom licensing agreement, no part of the    *
 * Nxt software, including this file, may be copied, modified, propagated,    *
 * or distributed except according to the terms contained in the LICENSE.txt  *
 * file.                                                                      *
 *                                                                            *
 * Removal or modification of this copyright notice is prohibited.            *
 *                                                                            *
 ******************************************************************************/

package prizm.http;

import prizm.Account;
import prizm.Attachment;
import prizm.Constants;
import prizm.DigitalGoodsStore;
import prizm.PrizmException;
import prizm.util.Convert;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

import static prizm.http.JSONResponses.DUPLICATE_REFUND;
import static prizm.http.JSONResponses.GOODS_NOT_DELIVERED;
import static prizm.http.JSONResponses.INCORRECT_DGS_REFUND;
import static prizm.http.JSONResponses.INCORRECT_PURCHASE;

public final class DGSRefund extends CreateTransaction {

    static final DGSRefund instance = new DGSRefund();

    private DGSRefund() {
        super(new APITag[] {APITag.DGS, APITag.CREATE_TRANSACTION},
                "purchase", "refundNQT");
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest req) throws PrizmException {

        Account sellerAccount = ParameterParser.getSenderAccount(req);
        DigitalGoodsStore.Purchase purchase = ParameterParser.getPurchase(req);
        if (sellerAccount.getId() != purchase.getSellerId()) {
            return INCORRECT_PURCHASE;
        }
        if (purchase.getRefundNote() != null) {
            return DUPLICATE_REFUND;
        }
        if (purchase.getEncryptedGoods() == null) {
            return GOODS_NOT_DELIVERED;
        }

        String refundValueNQT = Convert.emptyToNull(req.getParameter("refundNQT"));
        long refundNQT = 0;
        try {
            if (refundValueNQT != null) {
                refundNQT = Long.parseLong(refundValueNQT);
            }
        } catch (RuntimeException e) {
            return INCORRECT_DGS_REFUND;
        }
        if (refundNQT < 0 || refundNQT > Constants.MAX_BALANCE_NQT) {
            return INCORRECT_DGS_REFUND;
        }

        Account buyerAccount = Account.getAccount(purchase.getBuyerId());

        Attachment attachment = new Attachment.DigitalGoodsRefund(purchase.getId(), refundNQT);
        return createTransaction(req, sellerAccount, buyerAccount.getId(), 0, attachment);

    }

}
