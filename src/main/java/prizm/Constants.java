/** ****************************************************************************
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
 ***************************************************************************** */
package prizm;

import java.util.Calendar;
import java.util.TimeZone;

public final class Constants {

    public static final boolean isTestnet = Prizm.getBooleanProperty("prizm.isTestnet");
    public static final boolean isOffline = Prizm.getBooleanProperty("prizm.isOffline");
    public static final boolean isLightClient = Prizm.getBooleanProperty("prizm.isLightClient");
    public static final String customLoginWarning = Prizm.getStringProperty("prizm.customLoginWarning", null, false, "UTF-8");

    public static final int MAX_NUMBER_OF_TRANSACTIONS = 800;
    public static final int MIN_TRANSACTION_SIZE = 400;
    public static final int MAX_PAYLOAD_LENGTH = MAX_NUMBER_OF_TRANSACTIONS * MIN_TRANSACTION_SIZE;
    public static final int MAX_TRANSACTION_PAYLOAD_LENGTH = 1536;
    public static final long MAX_BALANCE_PRIZM = 10000000L;
    public static final long ONE_PRIZM = 100;
    public static final long MAX_BALANCE_NQT = MAX_BALANCE_PRIZM * ONE_PRIZM;
    public static final long INITIAL_BASE_TARGET = 15372286728L;
    public static final long MAX_BASE_TARGET = MAX_BALANCE_PRIZM * INITIAL_BASE_TARGET;
    public static final long MAX_BASE_TARGET_2 = INITIAL_BASE_TARGET * 50;
    public static final long MIN_BASE_TARGET = INITIAL_BASE_TARGET  * 9 / 10;
    public static final long MIN_FEE_NQT = 0L;
    public static final int MIN_BLOCKTIME_LIMIT = 50;
    public static final int MAX_BLOCKTIME_LIMIT = 70;
    public static final int BASE_TARGET_GAMMA = 64;
    public static final int MAX_ROLLBACK = Math.max(Prizm.getIntProperty("prizm.maxRollback"), 720);
    public static final int GUARANTEED_BALANCE_CONFIRMATIONS = isTestnet ? Prizm.getIntProperty("prizm.testnetGuaranteedBalanceConfirmations", 1440) : 1440;
    public static final int LEASING_DELAY = isTestnet ? Prizm.getIntProperty("prizm.testnetLeasingDelay", 1440) : 1440;
    public static final long MIN_FORGING_BALANCE_NQT = 1000 * ONE_PRIZM;

    public static final int MAX_TIMEDRIFT = 15; // allow up to 15 s clock difference

    // Such a toys are unneeded and it's behaviour is too unpredictable, so set to 0
    public static final int FORGING_DELAY = 0;
    public static final int FORGING_SPEEDUP = 0;

    public static final int MAX_ALIAS_URI_LENGTH = 512;
    public static final int MAX_ALIAS_LENGTH = 100;

    public static final int MAX_ARBITRARY_MESSAGE_LENGTH = 160;
    public static final int MAX_ENCRYPTED_MESSAGE_LENGTH = 160 + 16;

    public static final int MAX_PRUNABLE_MESSAGE_LENGTH = 512;  //ss * 42
    public static final int MAX_PRUNABLE_ENCRYPTED_MESSAGE_LENGTH = 512;  //ss * 42

    public static final int MIN_PRUNABLE_LIFETIME = isTestnet ? 1440 * 60 : 14 * 600 * 60;
    public static final int MAX_PRUNABLE_LIFETIME;
    public static final boolean ENABLE_PRUNING;

    static {
        int maxPrunableLifetime = Prizm.getIntProperty("prizm.maxPrunableLifetime");
        ENABLE_PRUNING = maxPrunableLifetime >= 0;
        MAX_PRUNABLE_LIFETIME = ENABLE_PRUNING ? Math.max(maxPrunableLifetime, MIN_PRUNABLE_LIFETIME) : Integer.MAX_VALUE;
    }
    public static final boolean INCLUDE_EXPIRED_PRUNABLE = Prizm.getBooleanProperty("prizm.includeExpiredPrunable");

    public static final int MAX_ACCOUNT_NAME_LENGTH = 100;
    public static final int MAX_ACCOUNT_DESCRIPTION_LENGTH = 512;

    public static final int TRANSPARENT_FORGING_BLOCK = 1440;
    public static final int TRANSPARENT_FORGING_BLOCK_3 = 1450;
    public static final int TRANSPARENT_FORGING_BLOCK_5 = 1455;
    public static final int TRANSPARENT_FORGING_BLOCK_8 = 78000;

    public static final int FORBID_FORGING_WITH_YOUNG_PUBLIC_KEY = 75000; // At this height we do not allow to forge if public key is announced in previous 1440 blocks or is not announced.
    public static final int NQT_BLOCK = isTestnet ? 0 : 0;   /// NQT ISPOLZUETSY S 0 BLOCKA
    public static final int REFERENCED_TRANSACTION_FULL_HASH_BLOCK = 91906; // isTestnet ? NQT_BLOCK : 140000;// //!!! nado poymat taymshtamp
    public static final int REFERENCED_TRANSACTION_FULL_HASH_BLOCK_TIMESTAMP = 5602294; // isTestnet ? 13031352 : 15134204;  //metka vremeni
    public static final int MAX_REFERENCED_TRANSACTION_TIMESPAN = 60 * 600 * 60;

    public static final String HARDFORK_ALIAS = "hardforkheight";

    public static final int ENFORCE_FULL_TRANSACTION_VALIDATION = 1500;

    public static final int LAST_KNOWN_BLOCK = 1440; // there was CHECKSUM_BLOCK_18; which is for height 251010

    public static final int[] MIN_VERSION = new int[] {1, 8, 1};
    public static final int[] MIN_PROXY_VERSION = new int[] {1, 8, 1};

    public static final boolean correctInvalidFees = Prizm.getBooleanProperty("prizm.correctInvalidFees");

    // --------[INIT #A]-------
    public static final long EPOCH_BEGINNING;

    static {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(Calendar.YEAR, 2018);
        calendar.set(Calendar.MONTH, Calendar.JULY);
        calendar.set(Calendar.DAY_OF_MONTH, 27);
        calendar.set(Calendar.HOUR_OF_DAY, 18);
        calendar.set(Calendar.MINUTE, 18);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        EPOCH_BEGINNING = calendar.getTimeInMillis();
    }

    public static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyz";

    private Constants() {
    } // never

    public static final String IN_BLOCK_ID = "inblockID";
    public static final String IN_BLOCK_HEIGHT = "inblockHeight";
    public static final String IN_TRANSACT_ID = "inTransactId";
    public static final String RANDOM = "random";

    // At this height we allow to INCREASE numberOfForkConfirmations MANUALLY inside prizm.properties to value higher then 1
    // At height below this one, numberOfForkConfirmations max value is 1
    public static final int FIRST_FORK_BLOCK = 74000;

    /*
     From this height we:
     1. validate encrypted message length (should be < MAX_ENCRYPTED_MESSAGE_LENGTH)
     2. validate duplicates for ACCOUNT INFO transactions
     Too long messages and duplicate ACCOUNT INFO transactions are rejected
    */
    public static final int ADVANCED_MESSAGING_VALIDATION = 100000;   // Should be OK

    // TODO can be safely deleted with a small rework
    public static final int CONTROL_TRX_TO_ORDINARY = 1500;     // allow only payments and messages
    public static final int FEE_MAX_10 = 1440;                  // Limit fee by 10 PZM (1000 cents)
	public static final int THIEF_BLOCK_BEGIN = 52573;
    public static final int CURRENT_BLOCK_VERSION = 3;
        
    public static final String GENESIS_SECRET_PHRASE = "132471795724474602596090885447809734073440405690173336453401505030282785124554759405469934798178728031618033988749894848204586834365638117720309179805762862135448622705260462818902449707207204189391137431415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";    
}
