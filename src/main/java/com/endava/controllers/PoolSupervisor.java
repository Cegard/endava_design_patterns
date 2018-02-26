package com.endava.controllers;
import com.endava.entities.Employee;
import com.endava.entities.Supervisor;

import java.util.Vector;
/**
 * This class define and control the structure that contains all the supervisors in the bank.
 */
public class PoolSupervisor extends PoolsController {
    private  int size;
    private Vector<Supervisor> poolOfSupervisorEmployees = new Vector<>();

    public PoolSupervisor(int size) {
        this.size = size;
        createPools();
    }

    /**
     * This method add one supervisor to the pool of cashiers.
     * @param employee represent the type of employee that will be add to the pool of supervisors
     */
    @Override
    public void addEmployeeToPool( Employee employee) {
        poolOfSupervisorEmployees.add((Supervisor) employee);
    }


    /**
     * This method pull the first supervisor in the pool for assign him to a client.
     * @return the first supervisor in the vector poolOfSupervisorEmployees.
     */
    @Override
    public Employee deleteEmployeeFromPool() {
        Supervisor supervisorAssigned = poolOfSupervisorEmployees.firstElement();
        poolOfSupervisorEmployees.remove(supervisorAssigned);
        return  supervisorAssigned;
    }

    /**
     * This method verify if are available supervisors
     * @return true if at least one supervisor is in the vector poolOfDirectorEmployees and false if the vector is empty.
     */
    @Override
    public boolean areEmployeesAvailables() {
        if(poolOfSupervisorEmployees.isEmpty()){
            return false;
        }
        return true;
    }

    /**
     * This method create supervisors and add them to the vector poolOfSupervisorEmployees.
     */
    @Override
    public void createPools() {
        for (int i = 0 ; i<size; i++){
            poolOfSupervisorEmployees.add(Supervisor.create(i));
        }
    }

}
