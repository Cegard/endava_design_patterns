package com.endava.controllers;

import com.endava.entities.Director;
import com.endava.entities.Employee;
import java.util.Vector;
/**
 * This class define and control the structure that contains all the directors in the bank.
 */
public class PoolDirector extends PoolsController {
    private  int size;
    private Vector<Director> poolOfDirectorEmployees = new Vector<>();

    public PoolDirector(int size) {
        this.size = size;
        createPools();
    }

    /**
     * This method add one director to the pool of directors.
     * @param employee represent the type of employee that will be add to the pool of directors
     */
    @Override
    public void addEmployeeToPool(Employee employee) {
        poolOfDirectorEmployees.add((Director) employee);
    }

    /**
     * This method pull the first director in the pool for assign him to a client.
     * @return the first director in the vector poolOfDirectorEmployees.
     */
    @Override
    public Employee deleteEmployeeFromPool() {
        Director directorAssigned = poolOfDirectorEmployees.firstElement();
        poolOfDirectorEmployees.remove(directorAssigned);
        return  directorAssigned;
    }

    /**
     * This method verify if are available directors
     * @return true if at least one director is in the vector poolOfDirectorEmployees and false if the vector is empty.
     */
    @Override
    public boolean areEmployeesAvailables() {
        if(poolOfDirectorEmployees.isEmpty()){
            return false;
        }
        return true;
    }

    /**
     * This method create directors and add them to the vector poolOfDirectorEmployees.
     */
    @Override
    public void createPools() {
        for (int i = 0; i < size; i++) {
            poolOfDirectorEmployees.add(Director.create(i));
        }
    }
}
