package com.payments.paystack.transactions;

import java.util.List;

public class Log {
    private int start_time, time_spent, attempts;
    private int errors;
    private boolean success, mobile;
    private List<Object> input;
    private List<History> history;

    public int getStartTime() {
        return this.start_time;
    }

    public int getTimeSpent() {
        return this.time_spent;
    }

    public int getAttempts() {
        return this.attempts;
    }

    public int getErrors() {
        return this.errors;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public boolean getMobile() {
        return this.mobile;
    }

    public boolean isMobile() {
        return this.mobile;
    }

    public List<Object> getInput() {
        return this.input;
    }

    public List<History> getHistory() {
        return this.history;
    }
}
