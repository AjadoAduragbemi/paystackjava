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
import com.payments.paystack.transactions.Transactions;
import com.payments.paystack.transactions.VerifyResponse;

import org.junit.Test;

public class TransactionsTest {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Transactions transactions = new Transactions();

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

        InitializeResponse initializeReponseBody = transactions.initialize(request);
        assertNotNull(initializeReponseBody);
        assertTrue(initializeReponseBody.getMessage(), initializeReponseBody.getStatus());

        String transactionReference = initializeReponseBody.getData().getReference();

        verifyTest(transactionReference);
    }

    public void verifyTest(String transactionAccessCode) throws IOException {
        VerifyResponse verifyReponseBody = transactions.verify(transactionAccessCode);;
        assertNotNull(verifyReponseBody);
    }

    @Test
    public void listAndFetchTransactionsTest() throws IOException {
        setupToken();
        ListTransactionsResponse listTransactionsReponseBody = transactions.listTransactions();
        assertNotNull(listTransactionsReponseBody);
        assertTrue(listTransactionsReponseBody.getMessage(), listTransactionsReponseBody.getStatus());
        List<TransactionData> listTransactionsReponseData = listTransactionsReponseBody.getData();
        assertTrue(listTransactionsReponseData.size() > 0);
        logBody(gson.toJson(listTransactionsReponseData.get(0)));
        fetchTransactionTest(listTransactionsReponseData.get(0).getId());
    }

    public void fetchTransactionTest(int id) throws IOException {
        FetchTransactionResponse fetchTransactionReponseBody = transactions.fetchTransaction(id);
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
        ChargeAuthorizationResponse chargeAuthorizationReponseBody = transactions.chargeAuthorization(authorizationCode, email, amount);
        assertNotNull(chargeAuthorizationReponseBody);
        logBody(gson.toJson(chargeAuthorizationReponseBody));
    }

    private void checkAuthorization(String authorizationCode, String email, long amount) throws IOException {
        CheckAuthorizationResponse checkAuthorizationReponseBody = transactions.checkAuthorization(authorizationCode, email, amount);
        assertNotNull(checkAuthorizationReponseBody);
        logBody(gson.toJson(checkAuthorizationReponseBody));
    }

    @Test
    public void deactivateAuthorizationTest() throws IOException {
        setupToken();
        DeactivateAuthorizationResponse deactivateAuthorizationReponseBody = transactions.deactivateAuthorization("authorizationCode");
        logBody(gson.toJson(deactivateAuthorizationReponseBody));
    }

    @Test
    public void timelineTest() throws IOException {
        setupToken();
        TimelineResponse timelineReponseBody = transactions.timeline("k7u3qiic3m");
        assertNotNull(timelineReponseBody);
        logBody(gson.toJson(timelineReponseBody));
    }

    @Test
    public void totalsTest() throws IOException {
        setupToken();
        TotalsResponse totalsReponseBody = transactions.totals();
        assertNotNull(totalsReponseBody);
        logBody(gson.toJson(totalsReponseBody));
    }

    @Test
    public void exportTest() throws IOException {
        setupToken();
        ExportResponse exportReponseBody = transactions.export();
        assertNotNull(exportReponseBody);
        logBody(gson.toJson(exportReponseBody));
    }

    private void logBody(String json) {
        System.out.println();
        System.out.println(json);
        System.out.println();
    }
}