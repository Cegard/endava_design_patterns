package com.endava.Operations;


public class CreateOperation {
    public static Operation createNewWithdrawOperation (){
        Operation withdraw = new Withdraw();
        withdraw.createOperation();
        return withdraw;
    }
    public static Operation createNewDepositOperation (){
        Operation deposit = new Deposit();
        deposit.createOperation();
        return deposit;
    }
    public static Operation createNewConsultOperation (){
        Operation consult = new Consult();
        consult.createOperation();
        return consult;
    }
}
