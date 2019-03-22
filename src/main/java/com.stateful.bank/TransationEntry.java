package com.stateful.bank;


class TransactionEntry {

    enum TransactionType { Debit,Credit }

    private TransactionType type;
    private int amount;

    TransactionEntry(TransactionType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    static TransactionEntry CreditTransaction(int amount){
        return new TransactionEntry(TransactionType.Credit,amount);
    }

    static TransactionEntry DebitTransaction(int amount){
        return new TransactionEntry(TransactionType.Debit,amount);
    }
}

