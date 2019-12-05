package com.payments.paystack.transactions;

public class Money {
    private String currency;
    private long amount;

    public String getCurrency() {
        return this.currency;
    }

    public long getAmount() {
        return this.amount;
    }
}
