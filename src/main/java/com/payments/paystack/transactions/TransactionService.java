package com.payments.paystack.transactions;

import com.payments.paystack.PaystackService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TransactionService extends PaystackService<TransactionsInterface> {
    private static TransactionService instance;
    private TransactionsInterface serviceApi;

    private TransactionService() {
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(TransactionsInterface.baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).client(getHttpClient()).build();
        serviceApi = retrofit.create(TransactionsInterface.class);
    }

    static {
        try {
            instance = new TransactionService();
        } catch (final Exception exception) {
            exception.printStackTrace();
        }
    }

    public static final TransactionService getInstance() {
        return (TransactionService) instance;
    }

    @Override
    public final TransactionsInterface getServiceApi() {
        return serviceApi;
    }
}