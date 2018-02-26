package com.endava.controllers;

import com.endava.entities.Cashier;
import com.endava.entities.Director;
import com.endava.entities.Employee;
import com.endava.entities.Supervisor;

import java.util.HashMap;

public class EmployeeController {


    private HashMap<String, EmployeeCreation> employeesCreationMethods = new HashMap<>();


    public EmployeeController(){
        this.addEmployeeCreationMethod("cashier", () -> Cashier.create());
        this.addEmployeeCreationMethod("director", () -> Director.create());
        this.addEmployeeCreationMethod("cashier", () -> Supervisor.create());
    }


    public void addEmployeeCreationMethod(String agentType, EmployeeCreation creationMethod){
        this.employeesCreationMethods.put(agentType, creationMethod);
    }


    public Employee createEmployee(String employeeType){

        return this.employeesCreationMethods.get(employeeType).create();
    }
}
