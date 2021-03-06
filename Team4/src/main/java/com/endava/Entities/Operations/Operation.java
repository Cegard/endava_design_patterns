package com.endava.Entities.Operations;

public abstract class Operation {
    protected abstract void initializeAttributes();
    public abstract String getTypeOperation();
    public abstract String getOperationDate();
    public abstract Double getOperationValue();
}
