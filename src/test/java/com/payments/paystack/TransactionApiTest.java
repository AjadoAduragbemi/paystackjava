package com.payments.paystack;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.payments.paystack.transactions.ChargeAuthorizationResponse;
import com.payments.paystack.transactions.CheckAuthorizationResponse;
import com.payments.paystack.transactions.CustomField;
import com.payments.paystack.transactions.DeactivateAuthorizationResponse;
import com.payments.paystack.transactions.ExportResponse;
import com.payments.paystack.transactions.FetchTransactionResponse;
import com.payments.paystack.transactions.InitializeRequest;
import com.payments.paystack.transactions.InitializeResponse;
import com.payments.paystack.transactions.ListTransactionsResponse;
import com.payments.paystack.transactions.Metadata;
import com.payments.paystack.transactions.TimelineResponse;
import com.payments.paystack.transactions.TotalsResponse;
import com.payments.paystack.transactions.TransactionData;
import com.payments.paystack.transactions.TransactionService;
import com.payments.paystack.transactions.VerifyResponse;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Response;

public class TransactionApiTest {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private void setupToken() {
        PaystackSetup.setAuthToken("sk_test_02df9413ed474f26fd3e4ba3a2289cff3f6b39ba");
    }

    @Test
    public void initializeTest() throws IOException {
        setupToken();

        InitializeRequest request = new InitializeRequest("customer@email.com", "NGN", "ACCT_ao069vk8mltusm7",
                "subaccount", 250000.0, 70000);
        CustomField customField = new CustomField("Mobile Number", "mobile_number", "+2348012345678");
        Metadata metadata = new Metadata();
        metadata.add(customField);
        request.setMetadata(metadata);

        Call<InitializeResponse> initialize = TransactionService.getInstance().getServiceApi().initialize(request);
        Response<InitializeResponse> initializeReponse = initialize.execute();

        assertNotNull(initializeReponse);
        InitializeResponse initializeReponseBody = initializeReponse.body();
        assertNotNull(initializeReponseBody);
        assertTrue(initializeReponseBody.getMessage(), initializeReponseBody.getStatus());

        String transactionReference = initializeReponseBody.getData().getReference();

        verifyTest(transactionReference);
    }

    public void verifyTest(String transactionAccessCode) throws IOException {
        assertNotNull(transactionAccessCode);
        Call<VerifyResponse> verify = TransactionService.getInstance().getServiceApi().verify(transactionAccessCode);
        Response<VerifyResponse> verifyReponse = verify.execute();
        assertNotNull(verifyReponse);
        VerifyResponse verifyReponseBody = verifyReponse.body();
        assertNotNull(verifyReponseBody);
    }

    @Test
    public void listAndFetchTransactionsTest() throws IOException {
        setupToken();

        Call<ListTransactionsResponse> listTransactions = TransactionService.getInstance().getServiceApi()
                .listTransactions();
        Response<ListTransactionsResponse> listTransactionsReponse = listTransactions.execute();

        assertNotNull(listTransactionsReponse);
        ListTransactionsResponse listTransactionsReponseBody = listTransactionsReponse.body();
        assertNotNull(listTransactionsReponseBody);
        assertTrue(listTransactionsReponseBody.getMessage(), listTransactionsReponseBody.getStatus());
        List<TransactionData> listTransactionsReponseData = listTransactionsReponseBody.getData();
        assertTrue(listTransactionsReponseData.size() > 0);
        logBody(gson.toJson(listTransactionsReponseData.get(0)));
        fetchTransactionTest(listTransactionsReponseData.get(0).getId());
    }

    public void fetchTransactionTest(int id) throws IOException {
        Call<FetchTransactionResponse> fetchTransaction = TransactionService.getInstance().getServiceApi()
                .fetchTransaction(id);
        Response<FetchTransactionResponse> fetchTransactionReponse = fetchTransaction.execute();
        assertNotNull(fetchTransactionReponse);
        FetchTransactionResponse fetchTransactionReponseBody = fetchTransactionReponse.body();
        assertNotNull(fetchTransactionReponseBody);
        logBody(gson.toJson(fetchTransactionReponseBody));
    }

    @Test
    public void authorizationTest() throws IOException {
        setupToken();
        String authorizationCode = "AUTH_b66w7hgx3l";
        String email = "testing@yahoo.com";
        long amount = 500000;
        chargeAuthorization(authorizationCode, email, amount);
        checkAuthorization(authorizationCode, email, amount);
    }

    private void chargeAuthorization(String authorizationCode, String email, long amount) throws IOException {
        Call<ChargeAuthorizationResponse> chargeAuthorization = TransactionService.getInstance().getServiceApi()
                .chargeAuthorization(authorizationCode, email, amount);
        Response<ChargeAuthorizationResponse> chargeAuthorizationReponse = chargeAuthorization.execute();
        assertNotNull(chargeAuthorizationReponse);
        ChargeAuthorizationResponse chargeAuthorizationReponseBody = chargeAuthorizationReponse.body();
        assertNotNull(chargeAuthorizationReponseBody);
        logBody(gson.toJson(chargeAuthorizationReponseBody));
    }

    private void checkAuthorization(String authorizationCode, String email, long amount) throws IOException {
        Call<CheckAuthorizationResponse> checkAuthorization = TransactionService.getInstance().getServiceApi()
                .checkAuthorization(authorizationCode, email, amount);
        Response<CheckAuthorizationResponse> checkAuthorizationReponse = checkAuthorization.execute();
        assertNotNull(checkAuthorizationReponse);
        CheckAuthorizationResponse checkAuthorizationReponseBody = checkAuthorizationReponse.body();
        assertNotNull(checkAuthorizationReponseBody);
        logBody(gson.toJson(checkAuthorizationReponseBody));
    }

    @Test
    public void deactivateAuthorizationTest() throws IOException {
        setupToken();
        Call<DeactivateAuthorizationResponse> deactivateAuthorization = TransactionService.getInstance().getServiceApi()
                .deactivateAuthorization("AUTH_mgr4e38i25");
        Response<DeactivateAuthorizationResponse> deactivateAuthorizationReponse = deactivateAuthorization.execute();
        assertNotNull(deactivateAuthorizationReponse);
        DeactivateAuthorizationResponse deactivateAuthorizationReponseBody = deactivateAuthorizationReponse.body();
        logBody(gson.toJson(deactivateAuthorizationReponseBody));
    }

    @Test
    public void timelineTest() throws IOException {
        setupToken();
        Call<TimelineResponse> timeline = TransactionService.getInstance().getServiceApi().timeline("k7u3qiic3m");
        Response<TimelineResponse> timelineReponse = timeline.execute();
        assertNotNull(timelineReponse);
        TimelineResponse timelineReponseBody = timelineReponse.body();
        assertNotNull(timelineReponseBody);
        logBody(gson.toJson(timelineReponseBody));
    }

    @Test
    public void totalsTest() throws IOException {
        setupToken();
        Call<TotalsResponse> totals = TransactionService.getInstance().getServiceApi().totals();
        Response<TotalsResponse> totalsReponse = totals.execute();
        assertNotNull(totalsReponse);
        TotalsResponse totalsReponseBody = totalsReponse.body();
        assertNotNull(totalsReponseBody);
        logBody(gson.toJson(totalsReponseBody));
    }

    @Test
    public void exportTest() throws IOException {
        setupToken();
        Call<ExportResponse> export = TransactionService.getInstance().getServiceApi()
                .export();
        Response<ExportResponse> exportReponse = export.execute();
        assertNotNull(exportReponse);
        ExportResponse exportReponseBody = exportReponse.body();
        assertNotNull(exportReponseBody);
        logBody(gson.toJson(exportReponseBody));
    }

    private void logBody(String json) {
        System.out.println();
        System.out.println(json);
        System.out.println();
    }
}