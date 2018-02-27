package com.endava.Operations;

public class Deposit extends Operation {
    private String operationType;
    @Override
    public void createOperation() {
        Operation deposit = new Deposit();
        operationType = "Deposit";
    }

    @Override
    public String getTypeOperation() {
        return operationType;
    }
}
