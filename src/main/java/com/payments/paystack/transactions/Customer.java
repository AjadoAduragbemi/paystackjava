package com.payments.paystack.transactions;

class Customer {
    private int id;
    private String customer_code, first_name, last_name, email;
    private Metadata metadata;

    private Customer() {
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