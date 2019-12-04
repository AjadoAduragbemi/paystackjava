package com.payments.paystack.transactions;

class Money {
    private String currency;
    private long amount;

    public String getCurrency() {
        return this.currency;
    }

    public long getAmount() {
        return this.amount;
    }
}
