package com.endava.entities;

/**
 * This class define a cashier and his information.
 * Every cashier is identify by a unique id.
 */
public class Cashier extends Employee {


    private Cashier(int id){
        this.id = id;
    }


    public static Cashier create(int id){

        return new Cashier(id);
    }
}
