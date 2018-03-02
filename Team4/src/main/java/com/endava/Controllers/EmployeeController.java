package com.endava.Controllers;

import com.endava.Entities.Employees.*;
import com.endava.Entities.EmployeesPool;

import java.util.HashMap;


public class EmployeeController {

    private static int consecutiveId = 0;
    private HashMap<String, EmployeeCreation> employeesCreationMethods = new HashMap<>();
    private EmployeesPool employeesPool;


    public EmployeeController(){
        this.employeesPool = new EmployeesPool();
        this.addEmployeeCreationMethod("cashier", Cashier.getCreationMethod());
        this.addEmployeeCreationMethod("supervisor", Supervisor.getCreationMethod());
        this.addEmployeeCreationMethod("director", Director.getCreationMethod());
    }


    public void addEmployeeCreationMethod(String agentType, EmployeeCreation creationMethod){
        this.employeesCreationMethods.put(agentType, creationMethod);
    }


    public Employee createEmployee(String employeeType){
        EmployeeController.consecutiveId++;
        Employee newEmployee = this.employeesCreationMethods.get(employeeType).create(EmployeeController.consecutiveId);
        this.addEmployeeToPool(newEmployee);

        return newEmployee;
    }


    public Employee getFreeAgent(){

        return this.employeesPool.getEmployee();
    }


    public void addEmployeeToPool(Employee agent){
        this.employeesPool.addEmployee(agent);
    }
}
