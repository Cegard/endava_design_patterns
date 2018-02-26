package com.endava.Operations;


public class CreateOperation {
    public Operation createNewWithdrawOperation (){
        Operation withdraw = new Withdraw();
        withdraw.createOperation();
        System.out.println("Type of operation: "+withdraw.getTypeOperation());
        return withdraw;
    }
    public Operation createNewDepositOperation (){
        Operation deposit = new Deposit();
        deposit.createOperation();
        System.out.println("Type of operation: "+deposit.getTypeOperation());
        return deposit;
    }
    public Operation createNewConsultOperation (){
        Operation consult = new Consult();
        consult.createOperation();
        System.out.println("Type of operation: "+consult.getTypeOperation());
        return consult;
    }
}
