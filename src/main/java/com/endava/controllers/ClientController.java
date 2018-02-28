package com.endava.controllers;


import com.endava.entities.Client;
import com.endava.entities.Operations.Operation;

public class ClientController {


    public static Client createClient(int customerId, String email, int accountId, Operation clientRrequest){

        return Client.createNewClient(customerId, email, accountId, clientRrequest);
    }
}
