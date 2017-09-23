package com.fistelo.debthelper.debtdetails;

import java.util.Date;

/**
 * Description to a single debt.
 */

public class Debt {

    private double amount;
    private String reason;
    private String description;
    private Date date;

    public Debt(double amount, String reason, String description, Date date) {
        this.amount = amount;
        this.reason = reason;
        this.description = description;
        this.date = date;
    }

    public Debt(double amount, String reason) {
        this.amount = amount;
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;

    }
    public String getReason() {
        return reason;
    }
}
