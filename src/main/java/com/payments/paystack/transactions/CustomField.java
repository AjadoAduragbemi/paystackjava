package com.payments.paystack.transactions;

public class CustomField {
    @SuppressWarnings("unused")
    private String display_name, variable_name, value;

    public CustomField(String display_name, String variable_name, String value) {
        this.display_name = display_name;
        this.variable_name = variable_name;
        this.value = value;
    }
}