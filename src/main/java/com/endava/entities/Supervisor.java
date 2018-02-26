package com.endava.entities;

/**
 * This class define a supervisor and his information.
 * Every supervisor is identify by a unique id.
 */
public class Supervisor extends Employee {


    private Supervisor(){
        Employee.totalEmployeesNumber++;
        this.initializeAttributes(Employee.totalEmployeesNumber, EmployeeAttentionPriority.SUPERVISOR);
    }


    public static Supervisor create(){
        Supervisor supervisor =  new Supervisor();
        return supervisor;
    }
}
