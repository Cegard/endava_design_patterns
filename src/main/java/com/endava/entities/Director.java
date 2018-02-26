package com.endava.entities;

/**
 * This class define a director and his information.
 * Every director is identify by a unique id.
 */
public class Director extends Employee {


    private Director(int id){
        this.id = id;
    }


    public static Director create(int id){

        return new Director(id);
    }
}
