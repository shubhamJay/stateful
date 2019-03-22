package com.stateful.bank;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Account {
    private AtomicInteger balance = new AtomicInteger(0);
    private ArrayList<TransactionEntry> ledger = new ArrayList();

    public Account(int balance) {
        if (balance > 0 ) credit(balance);
    }

    public int debit(int amount){
        if(amount <= this.balance.get()){
            this.ledger.add(TransactionEntry.DebitTransaction(amount));
            return this.balance.addAndGet( -amount);
        }
        else throw new RuntimeException("Not enough balance");
    }

    public int credit(int amount){
        this.ledger.add(TransactionEntry.CreditTransaction(amount));
        return this.balance.addAndGet(amount);
    }

    public int getBalance() {
        return balance.get();
    }
}
