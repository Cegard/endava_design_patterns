package com.endava.controllers;

import com.endava.entities.Cashier;
import com.endava.entities.Employee;
import java.util.Vector;

/**
 * This class define and control the structure that contains all the cashiers in the bank.
 */
public class PoolCashier extends PoolsController {
    private  int size;
    private Vector<Cashier> poolOfCashierEmployees = new Vector<>();
    public PoolCashier(int size) {
        this.size = size;
        createPools();
    }

    /**
     * This method add one cashier to the pool of cashiers.
     * @param employee represent the type of employee that will be add to the pool of cashiers
     */
    @Override
    public void addEmployeeToPool(Employee employee) {
        poolOfCashierEmployees.add((Cashier) employee);
    }

    /**
     * This method pull the first cashier in the pool for assign him to a client.
     * @return the first cashier in the vector poolOfCashierEmployees.
     */
    @Override
    public Cashier deleteEmployeeFromPool() {
        Cashier cashierAssigned = poolOfCashierEmployees.firstElement();
        poolOfCashierEmployees.remove(cashierAssigned);
        return  cashierAssigned;
    }

    /**
     * This method verify if are available cashiers
     * @return true if at least one cashier is in the vector poolOfCashierEmployees and false if the vector is empty.
     */
    @Override
    public boolean areEmployeesAvailables() {
        if(poolOfCashierEmployees.isEmpty()){
            return false;
        }
        return true;
    }

    /**
     * This method create cashiers and add them to the vector poolOfCashierEmployees.
     */
    @Override
    public void createPools() {
        for (int i = 0 ; i<size; i++){
            poolOfCashierEmployees.add(new Cashier(i));
        }
    }
}
