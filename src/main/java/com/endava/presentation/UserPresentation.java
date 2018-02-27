package com.endava.presentation;
import com.endava.entities.*;

/**
 * This class is in charge of present to the user all the information that is generate in the process of assign and attend clients.
 */
public class UserPresentation {


    /**
     * This method shows the information of an employee and his assigned client.
     * Shows what bank agent was assigned to what client.
     * @param employee represents the bank agent that sends the dispatcher and
     *                 that was assigned to the present client.
     * @param client represents the client that sends the dispatcher and that
     *               was assigned to the present bank agent.
     */
    public void printInformationOfAssignedEmployee(Employee employee, Client client){
        System.out.println("#---------------------------------------------------#");
        System.out.printf("%35s",""+"Client: " + client.getCustomerID() + ".\n");
        System.out.printf("%43s","Assigned to " + employee.getClass().getSimpleName() + ": " +
                employee.getId()+".\n");
        System.out.println("#---------------------------------------------------#");

    }


    /**
     * This method shows the time that took attend a specific client.
     * @param client represent the client that was attended.
     * @param timeOfAttention represent the time that took attend the present client.
     */
    public void printTimeSpendWithTheClient(Client client, double timeOfAttention){
        System.out.println();
        System.out.println("#---------------------------------------------------#");
        System.out.println("     The Client "+client.getCustomerID()+" was attended in: " +
                timeOfAttention + " seconds.");

        System.out.println("#---------------------------------------------------#");
        System.out.println();

    }
}
