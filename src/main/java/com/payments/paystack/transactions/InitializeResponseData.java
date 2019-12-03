package com.payments.paystack.transactions;

public class InitializeResponseData {
    private String authorization_url, access_code, reference;

    public String getAuthorizationUrl() {
        return this.authorization_url;
    }

    public String getAccessCode() {
        return this.access_code;
    }

    public String getReference() {
        return this.reference;
    }
}
