package com.endava.controllers;

import com.endava.entities.Cashier;
import com.endava.entities.Employee;
import com.endava.entities.EmployeePriorityComparator;

import java.util.PriorityQueue;
import java.util.Vector;

/**
 * This class define and control the structure that contains all the cashiers in the bank.
 */
public class EmployeesPool {
    private EmployeeController employeesController = new EmployeeController();
    private EmployeePriorityComparator employeesComparator = new EmployeePriorityComparator();
    private PriorityQueue<Employee> employeesPool = new PriorityQueue<>(employeesComparator);
    //Singleton
    private static EmployeesPool instance = new EmployeesPool();

    private EmployeesPool(){
        }

    public static EmployeesPool getInstance(){ return instance; }

    /**
     * This method add one cashier to the pool of cashiers.
     * @param employee represent the type of employee that will be add to the pool of cashiers
     */
    public void addEmployeeToPool(Employee employee) {
        this.employeesPool.add(employee);
    }


    /**
     * This method pull the first cashier in the pool for assign him to a client.
     * @return the first cashier in the vector poolOfCashierEmployees.
     */
    private synchronized Employee getEmployeeFromQueue(){

        return this.employeesPool.poll();
    }


    public Employee getEmployee() {
        Employee employeeFromQueue = this.employeesPool.poll();

        while (employeeFromQueue == null)
            employeeFromQueue = this.getEmployeeFromQueue();

        return employeeFromQueue;
    }


    /**
     * This method verify if are available cashiers
     * @return true if at least one cashier is in the vector poolOfCashierEmployees and false if the vector is empty.
     */
    public boolean areEmployeesAvailable() {
        return (employeesPool.isEmpty());
    }


    /**
     * This method create cashiers and add them to the vector poolOfCashierEmployees.
     */
    public void addNumberOfAgentsTypeToPool(int numberOfAgents, String type){

        for (int i = 0 ; i < numberOfAgents; i++)
            this.addEmployeeToPool(employeesController.createEmployee(type));
    }
}
