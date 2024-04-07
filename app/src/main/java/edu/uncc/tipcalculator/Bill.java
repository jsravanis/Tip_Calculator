package edu.uncc.tipcalculator;

import java.io.Serializable;

public class Bill implements Serializable {

    double billAmount;
    int tipPercent;

    public Bill() {
    }

    public Bill(double billAmount, int tipPercent) {
        this.billAmount = billAmount;
        this.tipPercent = tipPercent;
    }

    public Bill(int tipPercent) {
        this.tipPercent = tipPercent;
    }

    public int getTipPercent() {
        return tipPercent;
    }

    public void setTipPercent(int tipPercent) {
        this.tipPercent = tipPercent;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billAmount=" + billAmount +
                ", tipPercent=" + tipPercent +
                '}';
    }
}
