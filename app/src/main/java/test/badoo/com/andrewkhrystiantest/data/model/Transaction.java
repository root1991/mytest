package test.badoo.com.andrewkhrystiantest.data.model;

/**
 * Created by andrewkhristyan on 3/9/17.
 */

public class Transaction {

    private String transactionName;
    private int transactionsAmount;

    public Transaction(String transactionName, int transactionsAmount) {
        this.transactionName = transactionName;
        this.transactionsAmount = transactionsAmount;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public int getTransactionsAmount() {
        return transactionsAmount;
    }
}
