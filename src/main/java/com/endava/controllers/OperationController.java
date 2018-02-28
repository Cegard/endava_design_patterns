package com.endava.controllers;

import com.endava.entities.Operations.*;

import java.util.HashMap;
import java.util.Random;


public class OperationController {

    private HashMap<String, OperationCreation> operationCreationMethods = new HashMap<>();


    public OperationController(){

        this.operationCreationMethods.put("consult", Deposit.getCreationMethod());
        this.operationCreationMethods.put("deposit", Consult.getCreationMethod());
        this.operationCreationMethods.put("withdraw", Withdraw.getCreationMethod());
    }


    public Operation createNewOperation(String operationType){

        return this.operationCreationMethods.get(operationType).createOperation();
    }


    public Operation createNewOperation(){
        String[] operationTypes = {"consult", "deposit", "withdraw"};
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(operationTypes.length);

        return createNewOperation(operationTypes[randomNumber]);
    }
}
