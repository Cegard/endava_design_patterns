package com.endava.entities;


import com.endava.entities.Operations.Operation;

/**
 * This class define a client and his information.
 * Every client is identify by a unique id.
 */
public class Client {
        private int customerID;
        private String customerEmail;
        private int accountID;

        private Operation customerOperation;

        private Client(int customerID, String customerEmail, int accountID, Operation clientRrequest) {
            this.customerID = customerID;
            this.customerEmail = customerEmail;
            this.accountID = accountID;
            this.setCustomerOperation(clientRrequest);
        }


        public static Client createNewClient(int customerId, String email, int accountId, Operation clientRrequest){
            Client newClient = new Client(customerId, email, accountId, clientRrequest);
            return newClient;
        }


        public Operation getTransaction() {
            return customerOperation;
        }

        public int getCustomerID() {
            return customerID;
        }


        public String getCustomerEmail() { return customerEmail; }

        public int getAccountID() { return accountID; }


        public void setCustomerOperation(Operation customerOperation) {
            this.customerOperation = customerOperation;
        }
}
