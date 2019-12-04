package com.payments.paystack.transactions;

class Subaccount {
    private int id, percentage_charge;
    private String subaccount_code, business_name, description;
    private String primary_contact_name, primary_contact_email, primary_contact_phone; 
    private String settlement_bank, account_number;
    private Metadata metadata;

    public int getId() {
        return this.id;
    }

    public int getPercentageCharge() {
        return this.percentage_charge;
    }

    public String getSubaccountCode() {
        return this.subaccount_code;
    }

    public String getBusinessName() {
        return this.business_name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getPrimaryContactName() {
        return this.primary_contact_name;
    }

    public String getPrimaryContactEmail() {
        return this.primary_contact_email;
    }

    public String getPrimaryContactPhone() {
        return this.primary_contact_phone;
    }

    public String getSettlementBank() {
        return this.settlement_bank;
    }

    public String getAccountNumber() {
        return this.account_number;
    }

    public Metadata getMetadata() {
        return this.metadata;
    }
}
