package com.payments.paystack.transactions;

class Params {
    private String bearer, transaction_charge, percentage_charge;

    public String getBearer() {
        return this.bearer;
    }

    public String getTransactionCharge() {
        return this.transaction_charge;
    }

    public String getPercentageCharge() {
        return this.percentage_charge;
    }
    
}
