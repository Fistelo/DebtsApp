package com.fistelo.debthelper.debtdetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rados on 13.09.2017.
 */

public class DebtList {

    private Person person;
    private List<Debt> debtList;

    public DebtList(Person person) {
        this.person = person;
        debtList = new ArrayList<>();
    }

    public Person getPerson() {
        return person;
    }
    public void addToDebtlist(Debt debt){
        debtList.add(debt);
    }

}
