package com.endava.entities;

import com.endava.controllers.AgentSupplier;
import com.endava.controllers.EmployeesPool;
import com.endava.presentation.UserPresentation;

import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * This class is in charge of distribute the clients between the cashiers, supervisors and directors.
 * the dispatcher receive the number of cashiers, supervisors and directors, and also the number of clients that the bank has in the moment.
 */
public class Dispatcher {
    private EmployeesPool employeesPool;
    private ExecutorService executor;
    private UserPresentation userPresentation;
    private Vector<Client> clients = new Vector<Client>();


    public Dispatcher(int numberOfCashiers, int numberOfSupervisors, int numberOfDirectors) {
        employeesPool = new EmployeesPool(numberOfCashiers, numberOfSupervisors, numberOfDirectors);
        executor = Executors.newFixedThreadPool(10);
        userPresentation = new UserPresentation();
    }

    /**
     * This method take every client of the vector clients and proceed to attend him.
     * If are not available employees for attend the client, the method wait for two seconds and ask if are available employees again.
     */
    public void attendClients(int numberOfClients){
        this.createClients(numberOfClients);

        for (Client client : this.clients)
            this.attend(client);
    }


    /**
     * This method check for the disponibility of cashiers, supervisor and directors, at least one of them should be available.
     * @return true if one of the employees are available and false if all the employees are busy.
     */
    private boolean checkEmployeesAvailability(){

        return this.employeesPool.areEmployeesAvailable();
    }


    /**
     * This method simulate the attention that a cashier gives to the client
     * @param client represent the customer that the cashier will be attend
     */
    private void attend(Client client) {
        AgentSupplier supplier = new AgentSupplier(this.employeesPool.getEmployee());
        userPresentation.printInformationOfAssignedEmployee(supplier.getAgent(),
                client);
        CompletableFuture.supplyAsync(supplier, executor).thenAccept((agent) -> {
            this.employeesPool.addEmployeeToPool(agent);
            userPresentation.printTimeSpendWithTheClient(client, supplier.getTimeToAttend());
        });
    }


    /**
     * This method create the vector of clients assigning a unique id for every client in the bank.
     * @param numberOfClients define the number of clients in the bank, that is represented in the size of the vector.
     */
    private void createClients(int numberOfClients){

        for (int i = 1; i <= numberOfClients; i++)
            this.clients.add(new Client(i));
    }


    public void stopService(){
        this.executor.shutdown();
    }

}

