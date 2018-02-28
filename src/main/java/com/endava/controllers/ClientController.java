package com.endava.controllers;


import com.endava.entities.Client;

public class ClientController {


    public static Client createClient(int customerId, String email, int accountId){

        return Client.createNewClient(customerId, email, accountId);
    }
}
