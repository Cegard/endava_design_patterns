package com.endava.Operations;


public class CreateOperation {
    public Operation createNewWithdrawOperation (Operation operation){
        operation = new Withdraw();
        return operation;
    }
    public Operation createNewDepositOperation (Operation operation){
        operation = new Deposit();
        return operation;
    }
    public Operation createNewConsultOperation (Operation operation){
        operation = new Consult();
        return operation;
    }
}
