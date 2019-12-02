package com.payments.paystack.transactions;

import java.util.ArrayList;
import java.util.List;

public class Metadata {
    private List<CustomField> custom_fields;

    public Metadata() {
        custom_fields = new ArrayList<>();
    }

    public void add(CustomField customField) {
        custom_fields.add(customField);
    }
}