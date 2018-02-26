package com.endava.presentation;
import com.endava.entities.Cashier;
import com.endava.entities.Director;
import com.endava.entities.Supervisor;
import com.endava.entities.Client;

/**
 * This class is in charge of present to the user all the information that is generate in the process of assign and attend clients.
 */
public class UserPresentation {
    /**
     * This method shows the information of a specific cashier and his assigned client. Shows what cashier was assigned to what client.
     * @param cashier represents the cashier that sends the dispatcher and that was assigned to the present client.
     * @param client represents the client that sends the dispatcher and that was assigned to the present cashier.
     */
    public void printInformationOfAssignedCashier(Cashier cashier, Client client){
        System.out.println("#---------------------------------------------------#");
        System.out.printf("%35s",""+"  Client: "+client.getCustomerID()+".\n");
        System.out.printf("%40s","Assigned to Cashier: "+cashier.id+".\n");
        System.out.println("#---------------------------------------------------#");
    }

    /**
     * This method shows the information of a specific cashier and his assigned client. Shows what cashier was assigned to what client.
     * @param supervisor represents the supervisor that sends the dispatcher and that was assigned to the present client.
     * @param client represents the client that sends the dispatcher and that was assigned to the present supervisor.
     */
    public void printInformationOfAssignedSupervisor(Supervisor supervisor, Client client){
        System.out.println("#---------------------------------------------------#");
        System.out.printf("%35s",""+"Client: "+client.getCustomerID()+".\n");
        System.out.printf("%43s","Assigned to Supervisor: "+supervisor.id+".\n");
        System.out.println("#---------------------------------------------------#");

    }

    /**
     * This method shows the information of a specific cashier and his assigned client. Shows what cashier was assigned to what client.
     * @param director represents the director that sends the dispatcher and that was assigned to the present client.
     * @param client represents the client that sends the dispatcher and that was assigned to the present director.
     */
    public void printInformationOfAssignedDirector(Director director, Client client){
        System.out.println("#---------------------------------------------------#");
        System.out.printf("%35s",""+"Client: "+client.getCustomerID()+".\n");
        System.out.printf("%41s","Assigned to Director: "+director.id+".\n");
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
        System.out.println("     The Client "+client.getCustomerID()+" was attended in: "+timeOfAttention+" seconds.");
        System.out.println("#---------------------------------------------------#");
        System.out.println();

    }
}
