package com.endava.controllers;

import com.endava.entities.*;

import java.util.HashMap;

public class EmployeeController {

    private static int consecutiveId = 0;
    private HashMap<String, EmployeeCreation> employeesCreationMethods = new HashMap<>();


    public EmployeeController(){
        this.addEmployeeCreationMethod("cashier", (id) -> Cashier.create(id));
        this.addEmployeeCreationMethod("supervisor", (id) -> Supervisor.create(id) );
        this.addEmployeeCreationMethod("director", (id) -> Director.create(id));
    }


    public void addEmployeeCreationMethod(String agentType, EmployeeCreation creationMethod){
        this.employeesCreationMethods.put(agentType, creationMethod);
    }


    public Employee createEmployee(String employeeType){
        EmployeeController.consecutiveId++;
        return this.employeesCreationMethods.get(employeeType).create(EmployeeController.consecutiveId);
    }
}
