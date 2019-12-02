package com.payments.paystack;

public class PaystackSetup {
	private static final int DEFAULT_CONNECTION_TIMEOUT = 120;
	private static int readTimeout = DEFAULT_CONNECTION_TIMEOUT;
	private static int writeTimeout = DEFAULT_CONNECTION_TIMEOUT;

	private static String authToken;

	public static void setAuthToken(String authToken) {
		PaystackSetup.authToken = authToken;
	}

	public static String getAuthToken() {
		return authToken;
	}


	public static void setReadTimeout(int readTimeout) {
		PaystackSetup.readTimeout = readTimeout;
	}

	public static int getReadTimeout() {
		return readTimeout;
	}

	public static void setWriteTimeout(int writeTimeout) {
		PaystackSetup.writeTimeout = writeTimeout;
	}

	public static int getWriteTimeout() {
		return writeTimeout;
	}

	public static long getConnectTimeout() {
		return DEFAULT_CONNECTION_TIMEOUT;
	}

}


