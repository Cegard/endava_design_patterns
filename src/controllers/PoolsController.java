package controllers;

import entities.Employee;

/**
 * This class define the operation that every pool must implement for control the assignations of cashiers,
 * supervisors and directors.
 */
public abstract class PoolsController {
    public abstract void addEmployeeToPool(Employee employee);
    public abstract Employee deleteEmployeeFromPool();
    public abstract boolean areEmployeesAvailables();
    public abstract void createPools();

}
