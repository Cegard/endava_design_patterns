package com.endava.Operations;

import java.util.Random;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Deposit extends Operation {
    private String operationType;
    private double transactionValue;
    private String transactionDate;

    @Override
    public void createOperation() {
        Operation deposit = new Deposit();
        operationType = "Deposit";
        transactionValue = getTransactionValue();
        transactionDate = getTransactionDate();
    }

    @Override
    public String getTypeOperation() {
        return operationType;
    }

    private double getTransactionValue() {
        Random rnd = new Random();
        return  (rnd.nextDouble()*20000+1);
    }

    private String getTransactionDate() {
        Calendar date = GregorianCalendar.getInstance();
        String actualDate = date.getTime().toString();
        return actualDate;
    }

}
