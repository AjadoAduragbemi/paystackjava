package com.payments.paystack;

public abstract class PaystackResponse<T> {
    private boolean status;
    private String message;
    private T data;

    public boolean getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }
    
}
