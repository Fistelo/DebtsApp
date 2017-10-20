package com.fistelo.debthelper.customlist;

import com.fistelo.debthelper.Consts;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Pack200;

/**
 * Created by rados on 23.09.2017.
 */

public class ListData {

    List<String> debtors;
    List<Fraction> debtorToot;

    public ListData(){
        debtors = new ArrayList<>();
        debtorToot = new ArrayList<>();
    }

    public List<String> getDebtors() {
        return debtors;
    }

    public List<Fraction> getDebtorToot() {
        return debtorToot;
    }

    public void addDebtor(String name){
        debtors.add(name);
        debtorToot.add(new Fraction(1, debtors.size()));
        updateToot();
    }

    public void removeLast(){
        debtors.remove(debtors.size() - 1);
        debtorToot.remove(debtorToot.size() - 1);
        updateToot();
    }

    private void updateToot(){
        for(int i =0;i<debtors.size();i++){
            if(debtors.get(i) == Consts.noname){
                debtorToot.get(i).setDenominator(debtors.size());
            }
        }
    }

}
