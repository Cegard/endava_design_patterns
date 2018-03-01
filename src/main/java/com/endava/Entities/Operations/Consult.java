package com.endava.Entities.Operations;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Consult extends Operation {
    private String operationType;
    private String transactionDate;
    private static OperationCreation creationMethod = () -> new Consult();


    private Consult(){
        this.initializeAttributes();
    }


    @Override
    protected void initializeAttributes() {
        this.operationType = "Consult";
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
        return 0.0;
    }

    private String setTransactionDate() {
        Calendar date = GregorianCalendar.getInstance();
        String actualDate = date.getTime().toString();
        return actualDate;
    }


    public static OperationCreation getCreationMethod(){

        return creationMethod;
    }
}
