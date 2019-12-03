package com.payments.paystack.transactions;

import java.util.Date;

public class TransactionResponseData {
    private int id;
    private String domain, status, reference;
    private long amount, fees;
    private String message, gateway_response;
    private Date paid_at, created_at;
    private String channel, currency, ip_address;
    private Object metadata;
    private Object timeline;
    private Customer customer;
    private Authorization authorization;
    private Object plan;
    private Meta meta;
    private Log log;
    private Subaccount subaccount;

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

    public Date getPaidAt() {
        return this.paid_at;
    }

    public Date getCreatedAt() {
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

    public Object getMetadata() {
        return this.metadata;
    }

    public Object getTimeline() {
        return this.timeline;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Authorization getAuthorization() {
        return this.authorization;
    }

    public Object getPlan() {
        return this.plan;
    }

    public Meta getMeta() {
        return this.meta;
    }

    public long getFees() {
        return this.fees;
    }
    
    public Log getLog() {
        return this.log;
    }

    public Subaccount getSubaccount() {
        return this.subaccount;
    }
}
