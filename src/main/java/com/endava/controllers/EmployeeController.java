package com.endava.controllers;

import com.endava.entities.*;

import java.util.HashMap;

public class EmployeeController {


    private HashMap<String, EmployeeCreation> employeesCreationMethods = new HashMap<>();


    public EmployeeController(){
        this.addEmployeeCreationMethod("cashier", () -> Cashier.create());
        this.addEmployeeCreationMethod("supervisor", () -> Supervisor.create() );
        this.addEmployeeCreationMethod("director", () -> Director.create());
    }


    public void addEmployeeCreationMethod(String agentType, EmployeeCreation creationMethod){
        this.employeesCreationMethods.put(agentType, creationMethod);
    }


    public Employee createEmployee(String employeeType){

        return this.employeesCreationMethods.get(employeeType).create();
    }
}
