package com.endava.entities.Employees;

/**
 * This class define a supervisor and his information.
 * Every supervisor is identify by a unique id.
 */
public class Supervisor extends Employee {

    private static EmployeeCreation createNewSupervisor = (id -> new Supervisor(id));


    private Supervisor(int id){
        this.initializeAttributes(id, EmployeeAttentionPriority.SUPERVISOR);
    }


    public static EmployeeCreation getCreationMethod() {
        return createNewSupervisor;
    }
}
