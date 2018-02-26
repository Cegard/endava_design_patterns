package com.endava.entities;

import java.util.Scanner;

/**
 * This class is in charge for ask the data to instance the bank and send it to the dispatcher.
 * Ask for the number of every type of employees and for the number of clients in the bank.
 */
public class Bank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCashiers;
        int numberOfSupervisors;
        int numberOfDirectors;
        int numberOfClients;
        System.out.println("Enter the number of Cashiers - Supervisors - Directors (separated by spaces)");
        numberOfCashiers = scanner.nextInt();
        numberOfSupervisors = scanner.nextInt();
        numberOfDirectors = scanner.nextInt();
        System.out.println("Enter the number of clients");
        numberOfClients = scanner.nextInt();
        Dispatcher dispatcher = new Dispatcher(numberOfCashiers, numberOfSupervisors, numberOfDirectors);
        dispatcher.attendClients(numberOfClients);
        dispatcher.stopService();
    }
}
