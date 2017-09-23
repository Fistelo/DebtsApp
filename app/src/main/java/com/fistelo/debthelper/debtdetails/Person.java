package com.fistelo.debthelper.debtdetails;

/**
 * Created by rados on 13.09.2017.
 */

public class Person {

    private final String name;
    private double completeDebt;

    public Person(String name) {
        this.name = name;
        completeDebt = 0;
    }

    public void incrementCompleteDebt(double amount){
        completeDebt+=amount;
    }

    public double getCompleteDebt() {
        return completeDebt;
    }

    public String getName() {
        return name;
    }
}
