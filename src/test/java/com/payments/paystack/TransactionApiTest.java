package com.payments.paystack;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import com.payments.paystack.transactions.CustomField;
import com.payments.paystack.transactions.InitializeRequest;
import com.payments.paystack.transactions.InitializeResponse;
import com.payments.paystack.transactions.Metadata;
import com.payments.paystack.transactions.TransactionService;
import com.payments.paystack.transactions.VerifyResponse;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Response;

public class TransactionApiTest {

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
}