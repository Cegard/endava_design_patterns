package com.endava.Entities.Employees;

/**
 * This class define a director and his information.
 * Every director is identify by a unique id.
 */
public class Director extends Employee {

    private static EmployeeCreation createNewDirector = (id -> new Director(id));


    private Director(int id){
        this.initializeAttributes(id, EmployeeAttentionPriority.DIRECTOR);
    }


    public static EmployeeCreation getCreationMethod() {
        return createNewDirector;
    }
}
