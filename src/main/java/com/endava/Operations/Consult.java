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
        transactionDate = setTransactionDate();
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
        return 0.0;
    }

    private String setTransactionDate() {
        Calendar date = GregorianCalendar.getInstance();
        String actualDate = date.getTime().toString();
        return actualDate;
    }

}
