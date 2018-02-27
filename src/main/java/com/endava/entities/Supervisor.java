package com.endava.entities;

/**
 * This class define a supervisor and his information.
 * Every supervisor is identify by a unique id.
 */
public class Supervisor extends Employee {


    private Supervisor(int id){
        this.initializeAttributes(id, EmployeeAttentionPriority.SUPERVISOR);
    }


    public static Supervisor create(int id){
        Supervisor supervisor =  new Supervisor(id);
        return supervisor;
    }
}
