package com.endava.Controllers;


import com.endava.Entities.Client;
import com.endava.Entities.Operations.Operation;

public class ClientController {


    public static Client createClient(int customerId, String email, int accountId, Operation clientRrequest){

        return Client.createNewClient(customerId, email, accountId, clientRrequest);
    }
}
