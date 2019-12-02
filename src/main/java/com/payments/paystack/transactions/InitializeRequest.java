package com.payments.paystack.transactions;

public class InitializeRequest {
    private String email, currency, subaccount, bearer;
    private double amount;
    private int transaction_charge, invoice_limit;
    private Metadata metadata;

    /**
     * Creates a Transaction request object.
     * 
     * @param email
     * @param currency
     * @param subaccount
     * @param bearer
     * @param amount
     * @param transactionCharge
     */
    public InitializeRequest(String email, String currency, String subaccount, String bearer, double amount,
            int transactionCharge) {
        this.email = email;
        this.currency = currency;
        this.subaccount = subaccount;
        this.bearer = bearer;
        this.amount = amount;
        this.transaction_charge = transactionCharge;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSubaccount() {
        return this.subaccount;
    }

    public void setSubaccount(String subaccount) {
        this.subaccount = subaccount;
    }

    public String getBearer() {
        return this.bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTransactionCharge() {
        return this.transaction_charge;
    }

    public void setTransactionCharge(int transaction_charge) {
        this.transaction_charge = transaction_charge;
    }

    public int getInvoiceLimit() {
        return this.invoice_limit;
    }

    public void setInvoiceLimit(int invoice_limit) {
        this.invoice_limit = invoice_limit;
    }

    public Metadata getMetadata() {
        return this.metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}
