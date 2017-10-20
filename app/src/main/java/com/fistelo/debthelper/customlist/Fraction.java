package com.fistelo.debthelper.customlist;

/**
 * Created by rados on 20.10.2017.
 */

public class Fraction {
    private int counter;
    private int denominator;

    public Fraction(int counter, int denominator){
        this.counter = counter;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return Integer.toString(counter) + "/" + Integer.toString(denominator);
    }

    public int getIntDenominator() {
        return denominator;
    }

    public String getStringDenominator() {
        return Integer.toString(denominator);
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getIntCounter() {
        return counter;
    }

    public String getStringCounter() {
        return Integer.toString(counter);
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

}
