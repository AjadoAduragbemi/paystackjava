package com.payments.paystack.transactions;

import java.util.Date;

import com.google.gson.Gson;

public class TransactionData {
    private int id;
    private String domain, status, reference;
    private long amount;
    private String message, gateway_response, channel, currency, ip_address;
    private Metadata metadata;
    private Log log;
    private long fees;
    private Object fees_split;
    private Authorization authorization;
    private Customer customer;
    private Object plan;
    private String order_id;
    private Date paid_at, created_at, transaction_date;
    private Object plan_object;
    private Subaccount subaccount;

    public Authorization getAuthorization() {
        return this.authorization;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Object getPlan() {
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

    public Metadata getMetadata() {
        return this.metadata;
    }

    public Log getLog() {
        return this.log;
    }

    public long getFees() {
        return this.fees;
    }

    public FeesSplit getFeesSplit() {
        // had to do this to fix the error i was getting from calling listTransactions
        // apparently fees_split could be a string too 
        return (fees_split instanceof FeesSplit) ? (FeesSplit) fees_split : 
        new Gson().fromJson((String) fees_split, FeesSplit.class);
    }

    public String getOrderId() {
        return this.order_id;
    }

    public Date getTransactionDate() {
        return this.transaction_date;
    }

    public Object getPlanObject() {
        return this.plan_object;
    }

    public Subaccount getSubaccount() {
        return this.subaccount;
    }

}
