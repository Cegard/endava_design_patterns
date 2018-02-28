package com.endava.entities;

/**
 * This class define a client and his information.
 * Every client is identify by a unique id.
 */
public class Client {
        private int customerID;
        private String customerEmail;
        private int accountID;

        private Client(int customerID, String customerEmail, int accountID) {
            this.customerID = customerID;
            this.customerEmail = customerEmail;
            this.accountID = accountID;
        }


        public static Client createNewClient(int customerId, String email, int accountId){
            return new Client(customerId, email, accountId);
        }


        public int getCustomerID() {
            return customerID;
        }

        public void setCustomerID(int customerID) {
            this.customerID = customerID;
        }

        public String getCustomerEmail() { return customerEmail; }

        public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

        public int getAccountID() { return accountID; }

        public void setAccountID(int accountID) { this.accountID = accountID; }
}
