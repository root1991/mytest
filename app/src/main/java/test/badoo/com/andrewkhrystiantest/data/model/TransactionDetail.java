package test.badoo.com.andrewkhrystiantest.data.model;

/**
 * Created by andrewkhristyan on 3/9/17.
 */

public class TransactionDetail {

    private String price;
    private String currency;
    private double priceInPounds;

    public TransactionDetail(String price, double priceInPounds, String currency) {
        this.price = price;
        this.priceInPounds = priceInPounds;
        this.currency = currency;
    }

    public String getPrice() {
        return price;
    }

    public double getPriceInPounds() {
        return priceInPounds;
    }

    public String getCurrency() {
        return currency;
    }
}
