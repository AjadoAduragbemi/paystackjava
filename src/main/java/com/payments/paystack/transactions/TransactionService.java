package com.payments.paystack.transactions;

import com.payments.paystack.PaystackService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TransactionService extends PaystackService<TransactionsApi> {
    private static TransactionService instance;
    private TransactionsApi serviceApi;

    private TransactionService() {
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(TransactionsApi.baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).client(getHttpClient()).build();
        serviceApi = retrofit.create(TransactionsApi.class);
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
    public final TransactionsApi getServiceApi() {
        return serviceApi;
    }
}