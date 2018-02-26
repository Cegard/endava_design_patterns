package com.endava.entities;

/**
 * This abstract class define a Bank´s employee
 */
public abstract class Employee {

    protected int id;
    protected int priority;
    protected static int totalEmployeesNumber = 0;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getPriority() {
        return priority;
    }


    public void setPriority(int priority) {
        this.priority = priority;
    }


    protected void initializeAttributes(int id, EmployeeAttentionPriority employeePriority){
        this.id = id;
        this.priority = employeePriority.priority();
    }
}
