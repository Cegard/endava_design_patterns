package com.endava.Presentation;

import com.endava.Controllers.EmployeeController;
import com.endava.Controllers.OperationController;
import com.endava.Controllers.ClientController;
import com.endava.Controllers.Dispatcher;
import com.endava.Entities.Client;
import com.github.javafaker.Faker;

import java.util.Vector;

/**
 * This class is in charge for ask the data to instance the bank and send it to the dispatcher.
 * Ask for the number of every type of employees and for the number of clients in the bank.
 */
public class Bank {
    private Vector<Client> clients = new Vector<Client>();
    private Dispatcher dispatcher = Dispatcher.getInstance();
    private EmployeeController employeeController;
    private static OperationController operationController = new OperationController();


    public Bank(int numberOfCashiers, int numberOfSupervisors, int numberOfDirectors, int numberOfClients){
        this.employeeController = new EmployeeController();
        this.createClients(numberOfClients);
        this.createMultipleEmployeesOfSpecifiedType(numberOfCashiers, "cashier");
        this.createMultipleEmployeesOfSpecifiedType(numberOfSupervisors, "supervisor");
        this.createMultipleEmployeesOfSpecifiedType(numberOfDirectors, "director");
    }


    /**
     * This method take every client of the vector clients and proceed to attend him.
     * If are not available employees for attend the client, the method wait for two seconds and ask if are available employees again.
     */
    public void attendClients(){

        for (Client client : this.clients)
            dispatcher.attend(client, employeeController);
    }


    /**
     * This method create the vector of clients assigning a unique id for every client in the bank.
     * @param numberOfClients define the number of clients in the bank, that is represented in the size of the vector.
     */
    private void createClients(int numberOfClients){
        Faker faker = new Faker();

        for (int i = 1; i <= numberOfClients; i++){
            String customerEmail = faker.internet().emailAddress();
            clients.add(ClientController.createClient(i, customerEmail, i, operationController.createNewOperation()));
        }
    }


    private void createMultipleEmployeesOfSpecifiedType(int numberOfEmployees, String type){

        for (int i = 0; i < numberOfEmployees; i++)
            this.employeeController.createEmployee(type);
    }


    public void stopService(){
        this.dispatcher.shutdownExecutor();
    }
}
