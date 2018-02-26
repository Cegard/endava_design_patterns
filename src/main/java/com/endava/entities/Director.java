package com.endava.entities;

/**
 * This class define a director and his information.
 * Every director is identify by a unique id.
 */
public class Director extends Employee {


    private Director(){
        Employee.totalEmployeesNumber++;
        this.initializeAttributes(Employee.totalEmployeesNumber, EmployeeAttentionPriority.DIRECTOR);
    }


    public static Director create(){

        return new Director();
    }
}
