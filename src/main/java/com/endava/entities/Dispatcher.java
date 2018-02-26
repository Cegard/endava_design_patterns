package com.endava.entities;

import com.endava.controllers.AgentSupplier;
import com.endava.controllers.EmployeesPool;
import com.endava.controllers.PoolManager;
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
    public void attendClient(int numberOfClients){
        createClients(numberOfClients);
        
        for (int i = 0; i<numberOfClients; i++){
            while(!checkEmployeesAvailability()){
                waitForAEmployee();
            }
            Client client = clients.elementAt(i);
            assignEmployeeToClient(client);

        }
        executor.shutdown();

    }

    /**
     * This method check for the disponibility of cashiers, supervisor and directors, at least one of them should be available.
     * @return true if one of the employees are available and false if all the employees are busy.
     */
    private boolean checkEmployeesAvailability(){

        return this.employeesPool.areEmployeesAvailable();
    }

    /**
     * This method assign a employee to client.
     * First it assign a cashiers if are at least one available, if are not cashiers available assign a
     * supervisor and if are not supervisors available assign a director to client.
     * @param client represent the customer that the attendClient method took from the clients vector.
     */
    private void assignEmployeeToClient(Client client){
        userPresentation.printInformationOfAssignedEmployee(this.employeesPool.getEmployee(),
                client);
    }


    /**
     * This method simulate the attention that a cashier gives to the client
     * @param employee represents the respective cashier that was assigned to the client
     * @param client represent the customer that the cashier will be attend
     */
    private void attend(Employee employee, Client client) {
        Supplier<Double> supplier = new AgentSupplier();
        CompletableFuture.supplyAsync(supplier, executor).thenAccept((timeOfAttention) -> {
            employeesPool.poolControllerCashier.addEmployeeToPool(employee);
            userPresentation.printTimeSpendWithTheClient(client,timeOfAttention);
        });
    }

    /**
     * This method simulate the attention that a supervisor gives to the client
     * @param employee represents the respective supervisor that was assigned to the client
     * @param client represent the customer that the supervisor will be attend
     */
    private void attendClientWithSupervisor(Employee employee, Client client) {
        Supplier<Double> supplier = new AgentSupplier();
        CompletableFuture.supplyAsync(supplier, executor).thenAccept((timeOfAttention) -> {
            employeesPool.poolControllerSupervisor.addEmployeeToPool(employee);
            userPresentation.printTimeSpendWithTheClient(client,timeOfAttention);
        });
    }

    /**
     * This method simulate the attention that a director gives to the client
     * @param employee represents the respective director that was assigned to the client
     * @param client represent the customer that the director will be attend
     */
    private void attendClientWithDirector(Employee employee, Client client) {
        Supplier<Double> supplier = new AgentSupplier();
        CompletableFuture.supplyAsync(supplier, executor).thenAccept((timeOfAttention) -> {
            employeesPool.poolControllerDirector.addEmployeeToPool(employee);
            userPresentation.printTimeSpendWithTheClient(client,timeOfAttention);
        });
    }

    /**
     *  This method simulated the wait to check for a available employee, that is use for the attendClient method.
     */
    private void waitForAEmployee(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method create the vector of clients assigning a unique id for every client in the bank.
     * @param numberOfClients define the number of clients in the bank, that is represented in the size of the vector.
     */
    private void createClients(int numberOfClients){
        for (int i=0; i<numberOfClients; i++){
            clients.add(new Client(i));
        }
    }

}

