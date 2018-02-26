package com.endava.entities;

/**
 * This abstract class define a Bank´s employee
 */
public abstract class Employee {

    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //public abstract Employee create(int id);
}
