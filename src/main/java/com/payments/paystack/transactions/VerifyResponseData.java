package com.payments.paystack.transactions;

public class VerifyResponseData {
    private int id;
    private String domain, status, reference;
    private long amount;
    private String message, gateway_response, paid_at, created_at, channel, currency, ip_address;
    private Metadata metadata;
    private Log log;
    private Fees fees;
    private Authorization authorization;
    private Customer customer;
    private String plan;

    public String getGateway_response() {
        return this.gateway_response;
    }

    public String getPaid_at() {
        return this.paid_at;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public String getIp_address() {
        return this.ip_address;
    }

    public Authorization getAuthorization() {
        return this.authorization;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public String getPlan() {
        return this.plan;
    }

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
        return this.metadata;//.isEmpty() ? null : new Gson().fromJson(this.metadata, Metadata.class);
    }

    public Object getLog() {
        return this.log;
    }

    public Object getFees() {
        return this.fees;
    }

}
