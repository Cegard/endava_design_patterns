package com.endava.Operations;

public class Withdraw extends Operation {
    private String operationType;
    private Double operationValue;
    @Override
    public void createOperation() {
        Operation withdraw = new Withdraw();
        operationType = "Withdraw";


    }

    @Override
    public String getTypeOperation() {
        return operationType;
    }
}
