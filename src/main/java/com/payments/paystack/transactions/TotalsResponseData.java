package com.payments.paystack.transactions;

import java.util.List;

public class TotalsResponseData {
    private long total_transactions, total_volume, pending_transfers;
    private List<Money> total_volume_by_currency, pending_transfers_by_currency;

    public long getTotalTransactions() {
        return this.total_transactions;
    }

    public long getTotalVolume() {
        return this.total_volume;
    }

    public long getPendingTransfers() {
        return this.pending_transfers;
    }

    public List<Money> getTotalVolumeByCurrency() {
        return this.total_volume_by_currency;
    }

    public List<Money> getPendingTransfersByCurrency() {
        return this.pending_transfers_by_currency;
    }
    
}
