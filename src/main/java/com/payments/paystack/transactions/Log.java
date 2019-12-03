package com.payments.paystack.transactions;

import java.util.List;

class Log {
    private int time_spent, attempts;
    private Authentication authentication;
    private int errors;
    private boolean success, mobile;
    private List<Object> input;
    private Channel channel;
    private List<History> history;

    public int getTimeSpent() {
        return this.time_spent;
    }

    public int getAttempts() {
        return this.attempts;
    }

    public Authentication getAuthentication() {
        return this.authentication;
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

    public Channel getChannel() {
        return this.channel;
    }

    public List<History> getHistory() {
        return this.history;
    }
}
