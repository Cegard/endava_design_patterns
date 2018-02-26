package com.endava.Operations;

public class Consult extends Operation {
    private String operationType;
    @Override
    public void createOperation() {
        Operation consult = new Consult();
        operationType = "Consult";
    }

    @Override
    public String getTypeOperation() {
        return operationType;
    }

}
