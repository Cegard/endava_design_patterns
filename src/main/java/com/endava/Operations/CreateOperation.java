package com.endava.Operations;


public class CreateOperation {
    public static Operation createNewWithdrawOperation (){
        Operation withdraw = new Withdraw();
        withdraw.createOperation();
        System.out.println("Type of operation: "+withdraw.getTypeOperation());
        return withdraw;
    }
    public static Operation createNewDepositOperation (){
        Operation deposit = new Deposit();
        deposit.createOperation();
        System.out.println("Type of operation: "+deposit.getTypeOperation());
        return deposit;
    }
    public static Operation createNewConsultOperation (){
        Operation consult = new Consult();
        consult.createOperation();
        System.out.println("Type of operation: "+consult.getTypeOperation());
        return consult;
    }
}
