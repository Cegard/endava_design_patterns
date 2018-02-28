package com.endava.Operations;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Withdraw extends Operation {
    private String operationType;
    private double transactionValue;
    private String transactionDate;


    @Override
    public void createOperation() {
        Operation withdraw = new Withdraw();
        this.operationType = "Withdraw";
        this.transactionValue = setTransactionValue();
        this.transactionDate = setTransactionDate();
    }

    @Override
    public String getTypeOperation() {
        return operationType;
    }

    @Override
    public String getOperationDate() {
        return transactionDate;
    }

    @Override
    public Double getOperationValue() {
        return transactionValue;
    }


    private double setTransactionValue() {
        Random rnd = new Random();
        return  (rnd.nextDouble()*20000+1);
    }

    private String setTransactionDate() {
        Calendar date = GregorianCalendar.getInstance();
        String actualDate = date.getTime().toString();
        return actualDate;
    }
}
