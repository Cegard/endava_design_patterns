package com.endava.entities.Employees;

/**
 * This class define a cashier and his information.
 * Every cashier is identify by a unique id.
 */
public class Cashier extends Employee {

    private static EmployeeCreation createNewCashier = (id -> new Cashier(id));


    private Cashier(int id){
        this.initializeAttributes(id, EmployeeAttentionPriority.CASHIER);
    }


    public static EmployeeCreation getCreationMethod() {
        return createNewCashier;
    }
}
