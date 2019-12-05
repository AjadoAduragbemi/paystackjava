package com.payments.paystack.transactions;

import java.util.Date;

public class ChargeAuthorizationResponseData {
    private long amount;
    private String currency;
    private Date transaction_date;
    private String status, reference, domain;
    private Object metadata;
    private String gateway_response, message, channel, ip_address;
    private Object log;
    private Object fees;
    private Authorization authorization;
    private Customer customer;
    private int plan;

    public long getAmount() {
        return this.amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public Date getTransactionDate() {
        return this.transaction_date;
    }

    public String getStatus() {
        return this.status;
    }

    public String getReference() {
        return this.reference;
    }

    public String getDomain() {
        return this.domain;
    }

    public Object getMetadata() {
        return this.metadata;
    }

    public String getGatewayResponse() {
        return this.gateway_response;
    }

    public String getMessage() {
        return this.message;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getIpAddress() {
        return this.ip_address;
    }

    public Object getLog() {
        return this.log;
    }

    public Object getFees() {
        return this.fees;
    }

    public Authorization getAuthorization() {
        return this.authorization;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public int getPlan() {
        return this.plan;
    }
}
