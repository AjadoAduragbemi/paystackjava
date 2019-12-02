package com.payments.paystack.transactions;

import com.google.gson.Gson;

public class VerifyData {
    private int id;
    private String domain, status, reference;
    private long amount;
    private String message, gateway_response, paid_at, created_at, channel, currency, ip_address;
    private String metadata;
    private String log, fees;

    public int getId() {
        return this.id;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getStatus() {
        return this.status;
    }

    public String getReference() {
        return this.reference;
    }

    public long getAmount() {
        return this.amount;
    }

    public String getMessage() {
        return this.message;
    }

    public String getGatewayResponse() {
        return this.gateway_response;
    }

    public String getPaidAt() {
        return this.paid_at;
    }

    public String getCreatedAt() {
        return this.created_at;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getIpAddress() {
        return this.ip_address;
    }

    public Metadata getMetadata() {
        return this.metadata.isEmpty() ? null : new Gson().fromJson(this.metadata, Metadata.class);
    }

    public Object getLog() {
        return this.log;
    }

    public Object getFees() {
        return this.fees;
    }

}
