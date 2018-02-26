package com.endava.Operations;

public class Deposit extends Operation {

    @Override
    public Operation createOperation() {
        System.out.println("Hola, voy a depositar");
        return null;
    }
}
