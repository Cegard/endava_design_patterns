package com.endava.presentation;

import com.endava.controllers.OperationController;
import com.endava.entities.Operations.OperationCreation;
import com.endava.entities.Operations.Operation;
import com.endava.controllers.ClientController;
import com.endava.controllers.Dispatcher;
import com.endava.entities.Client;
import com.github.javafaker.Faker;

import java.util.Vector;

/**
 * This class is in charge for ask the data to instance the bank and send it to the dispatcher.
 * Ask for the number of every type of employees and for the number of clients in the bank.
 */
public class Bank {
    private Vector<Client> clients = new Vector<Client>();
    private Dispatcher dispatcher = Dispatcher.getInstance();


    public Bank(int numberOfCashiers, int numberOfSupervisors, int numberOfDirectors, int numberOfClients){
        this.dispatcher.addNewAgents(numberOfCashiers, numberOfSupervisors, numberOfDirectors);
        this.createClients(numberOfClients);
    }


    /**
     * This method take every client of the vector clients and proceed to attend him.
     * If are not available employees for attend the client, the method wait for two seconds and ask if are available employees again.
     */
    public void attendClients(){

        for (Client client : this.clients)
            dispatcher.attend(client);
    }


    /**
     * This method create the vector of clients assigning a unique id for every client in the bank.
     * @param numberOfClients define the number of clients in the bank, that is represented in the size of the vector.
     */
    private void createClients(int numberOfClients){
        Faker faker = new Faker();
        OperationController operationController = new OperationController();

        for (int i=0; i<numberOfClients; i++){
            String customerEmail = faker.internet().emailAddress();
            clients.add(ClientController.createClient(i, customerEmail, i, operationController.createNewOperation()));
        }
    }


    public void stopService(){
        this.dispatcher.shutdownExecutor();
    }
}
