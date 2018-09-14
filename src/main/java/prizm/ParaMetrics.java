/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prizm;

import java.io.Serializable;

/**
 *
 * @author zoi
 */
public class ParaMetrics implements Serializable {
    private long balance = 0l;
    private long amount = 0l;
    private long payout = 0l;
    private int beforeStamp = 0;
    private int afterStamp = 0;
    private double multiplier = 0;
    
    public boolean calculate() {
        double multi = 1d;
        double percent = 0d;
        if (balance>=100l && balance<=9999l) percent = 0.12d;
        if (balance>=10000l && balance<=99999l) percent = 0.14d;
        if (balance>=100000l && balance<=999999l) percent = 0.18d;
        if (balance>=1000000l && balance<=4999999l) percent = 0.21d;
        if (balance>=5000000l && balance<=9999999l) percent = 0.25d;
        if (balance>=10000000l && balance<=49999999l) percent = 0.28d;
        if (balance>=50000000l && balance<100000000l) percent = 0.33d;
        
        if (amount>=100000l         && amount<=999999l) multi = 2.18d;
        if (amount>=1000000l        && amount<=9999999l) multi = 2.36d;
        if (amount>=10000000l       && amount<=99999999l) multi = 2.77d;
        if (amount>=100000000l      && amount<=999999999l) multi = 3.05d;
        if (amount>=1000000000l     && amount<=9999999999l) multi = 3.36d;
        if (amount>=10000000000l    && amount<=99999999999l) multi = 3.88d;
        if (amount>=100000000000l) multi = 4.37d;
                
        this.multiplier = (multi * percent) / 100d;
        double days = (afterStamp - beforeStamp) / 86400d;
        payout = (long) Math.floor((double) balance * (days * this.multiplier));

        return true;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getPayout() {
        return payout;
    }

    public int getBeforeStamp() {
        return beforeStamp;
    }

    public void setBeforeStamp(int beforeStamp) {
        this.beforeStamp = beforeStamp;
    }

    public int getAfterStamp() {
        return afterStamp;
    }

    public void setAfterStamp(int afterStamp) {
        this.afterStamp = afterStamp;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setPayout(long payout) {
        this.payout = payout;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public String toString() {
        return "ParaMetrics{" + "balance=" + balance + ", amount=" + amount + ", payout=" + payout + ", beforeStamp=" + beforeStamp + ", afterStamp=" + afterStamp + '}';
    }
}
