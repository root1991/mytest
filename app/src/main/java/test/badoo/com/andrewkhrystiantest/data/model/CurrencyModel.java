package test.badoo.com.andrewkhrystiantest.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andrewkhristyan on 3/9/17.
 */

public class CurrencyModel {

    @SerializedName("from")
    private String from;
    @SerializedName("rate")
    private double rate;
    @SerializedName("to")
    private String to;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
