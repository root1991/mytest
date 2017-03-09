package test.badoo.com.andrewkhrystiantest.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andrewkhristyan on 3/9/17.
 */

public class RoughTransaction {

    @SerializedName("amount")
    private double amount;
    @SerializedName("sku")
    private String sku;
    @SerializedName("currency")
    private String currency;

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getSku() {
        return sku;
    }

}
