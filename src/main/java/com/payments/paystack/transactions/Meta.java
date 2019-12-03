package com.payments.paystack.transactions;

class Meta {
    private int total, skipped, perPage, page, pageCount;

    public int getTotal() {
        return this.total;
    }

    public int getSkipped() {
        return this.skipped;
    }

    public int getPerPage() {
        return this.perPage;
    }

    public int getPage() {
        return this.page;
    }

    public int getPageCount() {
        return this.pageCount;
    }
}
