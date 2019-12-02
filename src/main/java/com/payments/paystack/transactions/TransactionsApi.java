package com.payments.paystack.transactions;

import retrofit2.Call;

public class TransactionsApi implements TransactionsInterface {

    @Override
    public Call<InitializeResponse> initialize(InitializeRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Call<VerifyResponse> verify(String reference) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Call<ListTransactionsResponse> listTransactions() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Call<FetchTransactionResponse> fetchTransaction(int id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}