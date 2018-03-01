package com.endava.AppClient;

import com.endava.Presentation.Bank;

import java.util.Scanner;

public class BaseMain {

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
        Bank bank = new Bank(numberOfCashiers, numberOfSupervisors, numberOfDirectors, numberOfClients);
        bank.attendClients();
        bank.stopService();
    }
}
