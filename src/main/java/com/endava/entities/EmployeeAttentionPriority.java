package com.endava.entities;

public enum EmployeeAttentionPriority {

    DIRECTOR (1),
    SUPERVISOR (2),
    CASHIER (3);

    private int priority;


    EmployeeAttentionPriority(int id){
        this.priority = id;
    }


    public int priority(){
        return priority;
    }
}
