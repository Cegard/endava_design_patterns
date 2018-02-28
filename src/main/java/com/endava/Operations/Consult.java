package com.endava.Operations;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Consult extends Operation {
    private String operationType;
    private String transactionDate;
    @Override
    public void createOperation() {
        Operation consult = new Consult();
        operationType = "Consult";
        transactionDate = getTransactionDate();
    }

    @Override
    public String getTypeOperation() {
        return operationType;
    }

    private String getTransactionDate() {
        Calendar date = GregorianCalendar.getInstance();
        String actualDate = date.getTime().toString();
        return actualDate;
    }

}
