package com.endava.Entities;

import com.endava.Entities.Employees.Employee;
import com.endava.Entities.Employees.EmployeePriorityComparator;

import java.util.PriorityQueue;

/**
 * This class define and control the structure that contains all the cashiers in the bank.
 */
public class EmployeesPool {
    private EmployeePriorityComparator employeesComparator = new EmployeePriorityComparator();
    public PriorityQueue<Employee> employeesPool;


    public EmployeesPool(){
        employeesPool = new PriorityQueue<>(employeesComparator);
    }

    /**
     * This method add one cashier to the pool of cashiers.
     * @param employee represent the type of employee that will be add to the pool of cashiers
     */
    public void addEmployee(Employee employee){
        this.addEmployeeToPool(employee);
    }


    private void addEmployeeToPool(Employee employee){
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
        Employee employeeFromQueue = this.getEmployeeFromQueue();

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
}
