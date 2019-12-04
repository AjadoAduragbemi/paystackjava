package com.payments.paystack.transactions;

class FeesSplit {
    private int paystack, subaccount;
    private String integration;
    private Params params;

    public int getPaystack() {
      return this.paystack;
    }

    public int getSubaccount() {
      return this.subaccount;
    }

    public String getIntegration() {
      return this.integration;
    }

    public Params getParams() {
      return this.params;
    }
}
