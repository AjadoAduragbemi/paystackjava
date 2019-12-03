package com.payments.paystack.transactions;

class Authorization {
    private String authorization_code, bin, last4, exp_month, exp_year, channel, card_type, bank, country_code,
            brand, signature;
    private boolean reusable;

    public String getAuthorizationCode() {
        return this.authorization_code;
    }

    public String getBin() {
        return this.bin;
    }

    public String getLast4() {
        return this.last4;
    }

    public String getExpMonth() {
        return this.exp_month;
    }

    public String getExpYear() {
        return this.exp_year;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getCardType() {
        return this.card_type;
    }

    public String getBank() {
        return this.bank;
    }

    public String getCountryCode() {
        return this.country_code;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getSignature() {
        return this.signature;
    }

    public boolean getReusable() {
        return this.reusable;
    }

    public boolean isReusable() {
        return this.reusable;
    }
}