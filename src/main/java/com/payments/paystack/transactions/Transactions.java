package com.payments.paystack.transactions;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class Transactions {

    public InitializeResponse initialize(InitializeRequest request) throws IOException {
        Call<InitializeResponse> initialize = TransactionService.getInstance().getServiceApi().initialize(request);
        Response<InitializeResponse> initializeReponse = initialize.execute();
        return initializeReponse.body();
    }

    public VerifyResponse verify(String reference) throws IOException {
        Call<VerifyResponse> verify = TransactionService.getInstance().getServiceApi().verify(reference);
        Response<VerifyResponse> verifyReponse = verify.execute();
        return verifyReponse.body();
    }

    public ListTransactionsResponse listTransactions() throws IOException {
        Call<ListTransactionsResponse> listTransactions = TransactionService.getInstance().getServiceApi()
                .listTransactions();
        Response<ListTransactionsResponse> listTransactionsReponse = listTransactions.execute();
        return listTransactionsReponse.body();
    }

    public FetchTransactionResponse fetchTransaction(int id) throws IOException {
        Call<FetchTransactionResponse> fetchTransaction = TransactionService.getInstance().getServiceApi()
                .fetchTransaction(id);
        Response<FetchTransactionResponse> fetchTransactionReponse = fetchTransaction.execute();
        return fetchTransactionReponse.body();
    }

    public ChargeAuthorizationResponse chargeAuthorization(String authorizationCode, String email, long amount)
            throws IOException {
        Call<ChargeAuthorizationResponse> chargeAuthorization = TransactionService.getInstance().getServiceApi()
                .chargeAuthorization(authorizationCode, email, amount);
        Response<ChargeAuthorizationResponse> chargeAuthorizationReponse = chargeAuthorization.execute();
        return chargeAuthorizationReponse.body();
    }

    public CheckAuthorizationResponse checkAuthorization(String authorizationCode, String email, long amount)
            throws IOException {
        Call<CheckAuthorizationResponse> checkAuthorization = TransactionService.getInstance().getServiceApi()
                .checkAuthorization(authorizationCode, email, amount);
        Response<CheckAuthorizationResponse> checkAuthorizationReponse = checkAuthorization.execute();
        return checkAuthorizationReponse.body();
    }

    public DeactivateAuthorizationResponse deactivateAuthorization(String authorizationCode) throws IOException {
        Call<DeactivateAuthorizationResponse> deactivateAuthorization = TransactionService.getInstance().getServiceApi()
                .deactivateAuthorization(authorizationCode);
        Response<DeactivateAuthorizationResponse> deactivateAuthorizationReponse = deactivateAuthorization.execute();
        return deactivateAuthorizationReponse.body();
    }

    public TimelineResponse timeline(String id_or_reference) throws IOException {
        Call<TimelineResponse> timeline = TransactionService.getInstance().getServiceApi().timeline(id_or_reference);
        Response<TimelineResponse> timelineReponse = timeline.execute();
        return timelineReponse.body();
    }

    public TotalsResponse totals() throws IOException {
        Call<TotalsResponse> totals = TransactionService.getInstance().getServiceApi().totals();
        Response<TotalsResponse> totalsReponse = totals.execute();
        return totalsReponse.body();
    }

    public ExportResponse export() throws IOException {
        Call<ExportResponse> export = TransactionService.getInstance().getServiceApi()
                .export();
        Response<ExportResponse> exportReponse = export.execute();
        return exportReponse.body();
    }

}