package com.endava.controllers;

import com.endava.entities.Cashier;
import com.endava.entities.Director;
import com.endava.entities.Supervisor;

import java.util.HashMap;

public class EmployeeController {


    private HashMap<String, EmployeeCreation> employeesCreationMethods = new HashMap<>();


    public EmployeeController(){
        this.addEmployeeCreationMethod("cashier", (id) -> Cashier.create(id));
        this.addEmployeeCreationMethod("director", (id) -> Director.create(id));
        this.addEmployeeCreationMethod("cashier", (id) -> Supervisor.create(id));
    }


    public void addEmployeeCreationMethod(String agentType, EmployeeCreation creationMethod){
        this.employeesCreationMethods.put(agentType, creationMethod);
    }
}
