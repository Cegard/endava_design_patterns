package com.endava.entities;

/**
 * This class define a cashier and his information.
 * Every cashier is identify by a unique id.
 */
public class Cashier extends Employee {


    private Cashier(){
        Employee.totalEmployeesNumber++;
        this.initializeAttributes(Employee.totalEmployeesNumber, EmployeeAttentionPriority.CASHIER);
    }


    public static Cashier create(){

        return new Cashier();
    }
}
