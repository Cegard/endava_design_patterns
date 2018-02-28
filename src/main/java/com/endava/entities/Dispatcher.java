package com.endava.entities;

import com.endava.Operations.*;
import com.endava.controllers.AgentSupplier;
import com.endava.controllers.EmployeesPool;
import com.endava.presentation.UserPresentation;
import com.github.javafaker.Faker;

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
    private CreateOperation createOperation;
    private Vector<Client> clients = new Vector<Client>();

    //Singleton nexted
    private static Dispatcher instance = new Dispatcher();

    private Dispatcher() {
        this.employeesPool = EmployeesPool.getInstance();
        userPresentation = new UserPresentation();
        createOperation = new CreateOperation();
        executor = Executors.newFixedThreadPool(10);
    }

    public void addNewAgents(int cashiers, int supervisors, int directors){
        this.employeesPool.addNumberOfAgentsTypeToPool(cashiers, "cashier");
        this.employeesPool.addNumberOfAgentsTypeToPool(supervisors, "supervisor");
        this.employeesPool.addNumberOfAgentsTypeToPool(directors, "director");
    }

    public static Dispatcher getInstance(){ return instance; }

    /**
     * This method take every client of the vector clients and proceed to attend him.
     * If are not available employees for attend the client, the method wait for two seconds and ask if are available employees again.
     */
    public void attendClients(int numberOfClients){
        this.createClients(numberOfClients);
        createClients(numberOfClients);

        for (Client client : this.clients){
            Operation clientOperation = simulateOperation();
            attend(client);
        }
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


    public void stopService() {
        this.executor.shutdown();
    }


    /**
     * This method create the vector of clients assigning a unique id for every client in the bank.
     * @param numberOfClients define the number of clients in the bank, that is represented in the size of the vector.
     */
    private void createClients(int numberOfClients){
        Faker faker = new Faker();

        for (int i=0; i<numberOfClients; i++){
            String customerEmail = faker.internet().emailAddress();
            clients.add(new Client(i, customerEmail, i));
        }
    }

    private Operation simulateOperation() {
        int randomOperation = (int) Math.floor(Math.random() * 3 + 1);
        Operation operation = null;
        if (randomOperation == 1) {
            operation = createOperation.createNewConsultOperation();
        } else if (randomOperation == 2) {
            operation = createOperation.createNewDepositOperation();
        } else {
            operation = createOperation.createNewWithdrawOperation();
        }
        System.out.println("Type operation in the dispatcher: "+operation.getTypeOperation());

        return operation;
    }
}
