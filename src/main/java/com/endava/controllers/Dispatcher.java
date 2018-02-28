package com.endava.controllers;

import com.endava.entities.Client;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class is in charge of distribute the clients between the cashiers, supervisors and directors.
 * the dispatcher receive the number of cashiers, supervisors and directors, and also the number of clients that the bank has in the moment.
 */
public class Dispatcher {
    private EmployeesPool employeesPool;
    private ExecutorService executor;

    //Singleton nested
    private static Dispatcher instance = new Dispatcher();

    private Dispatcher() {
        this.employeesPool = EmployeesPool.getInstance();
        executor = Executors.newFixedThreadPool(10);
    }

    public void addNewAgents(int cashiers, int supervisors, int directors){
        this.employeesPool.addNumberOfAgentsTypeToPool(cashiers, "cashier");
        this.employeesPool.addNumberOfAgentsTypeToPool(supervisors, "supervisor");
        this.employeesPool.addNumberOfAgentsTypeToPool(directors, "director");
    }

    public static Dispatcher getInstance(){ return instance; }

    /**
     * This method simulate the attention that a cashier gives to the client
     * @param client represent the customer that the cashier will be attend
     */
    public void attend(Client client) {
        AgentSupplier supplier = new AgentSupplier(this.employeesPool.getEmployee());
        Utilities.printInformationOfAssignedEmployee(supplier.getAgent(),
                client);
        CompletableFuture.supplyAsync(supplier, executor).thenAccept((agent) -> {
            this.employeesPool.addEmployeeToPool(agent);
            Utilities.printTimeSpendWithTheClient(client, supplier.getTimeToAttend());
        });
    }


    public void shutdownExecutor() {
        this.executor.shutdown();
    }
}
