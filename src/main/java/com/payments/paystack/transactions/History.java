package com.payments.paystack.transactions;

class History {
    private String type, message;
    private int time;

    public String getType() {
        return this.type;
    }

    public String getMessage() {
        return this.message;
    }

    public int getTime() {
        return this.time;
    }

}
