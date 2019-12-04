package com.payments.paystack.transactions;

import com.payments.paystack.Paystack;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TransactionsInterface {

	static final String baseUrl = Paystack.baseUrl;

	@POST(baseUrl + "transaction/initialize")
	public abstract Call<InitializeResponse> initialize(@Body InitializeRequest request);

	@GET(baseUrl + "transaction/verify/{reference}")
	public Call<VerifyResponse> verify(@Path("reference") String reference);

	@GET(baseUrl + "transaction")
	public Call<ListTransactionsResponse> listTransactions();

	@GET(baseUrl + "transaction/{id}")
	public Call<FetchTransactionResponse> fetchTransaction(@Path("id") int id);

	@POST(baseUrl + "transaction/charge_authorization")
	@FormUrlEncoded
	public abstract Call<ChargeAuthorizationResponse> chargeAuthorization(
			@Field("authorization_code") String authorizationCode, @Field("email") String email,
			@Field("amount") long amount);

	@POST(baseUrl + "transaction/check_authorization")
	@FormUrlEncoded
	public abstract Call<ChargeAuthorizationResponse> checkAuthorization(
			@Field("authorization_code") String authorizationCode, @Field("email") String email,
			@Field("amount") long amount);

	@POST(baseUrl + "transaction/deactivate_authorization")
	@FormUrlEncoded
	public abstract Call<ChargeAuthorizationResponse> deactivateAuthorization(
			@Field("authorization_code") String authorizationCode);

	@GET(baseUrl + "transaction/timeline/{id_or_reference}")
	public Call<TimelineResponse> timeline(@Path("id_or_reference") int id_or_reference);

	@GET(baseUrl + "transaction/totals")
	public Call<TotalsResponse> totals();

	@GET(baseUrl + "transaction/export")
	public Call<ExportResponse> export();

}