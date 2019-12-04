package com.payments.paystack.transactions;

class Customer {
    private int id;
    private String customer_code, first_name, last_name, email, phone, risk_action;
    private Metadata metadata;

    public String getRiskAction() {
        return this.risk_action;
    }

    public String getPhone() {
        return this.phone;
    }

    public Metadata getMetadata() {
        return this.metadata;
    }

    public int getId() {
        return this.id;
    }

    public String getCustomerCode() {
        return this.customer_code;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public String getLastName() {
        return this.last_name;
    }

    public String getEmail() {
        return this.email;
    }
}