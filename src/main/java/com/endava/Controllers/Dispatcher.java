package com.endava.Controllers;

import com.endava.Entities.Client;
import com.endava.Entities.Message.MessageService;
import com.endava.legacy.CuponMktService;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class is in charge of distribute the clients between the cashiers, supervisors and directors.
 * the dispatcher receive the number of cashiers, supervisors and directors, and also the number of clients that the bank has in the moment.
 */
public class Dispatcher {
    private ExecutorService executor;

    //Singleton nested
    private static Dispatcher instance = new Dispatcher();

    private Dispatcher() {
        executor = Executors.newFixedThreadPool(10);
    }

    public static Dispatcher getInstance(){ return instance; }

    /**
     * This method simulate the attention that a cashier gives to the client
     * @param client represent the customer that the cashier will be attend
     */
    public void attend(Client client, EmployeeController employeesController,
                       MessageService messageService) {
        AgentSupplier supplier = new AgentSupplier(employeesController.getFreeAgent());
        Utilities.printInformationOfAssignedEmployee(supplier.getAgent(),
                client);
        CompletableFuture.supplyAsync(supplier, executor).thenAccept((agent) -> {
            employeesController.addEmployeeToPool(agent);
            Utilities.printTimeSpendWithTheClient(client, supplier.getTimeToAttend());
            messageService.createMessage(client, agent);
        });
    }

    public void shutdownExecutor() {
        this.executor.shutdown();
    }
}
