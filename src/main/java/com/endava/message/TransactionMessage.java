package com.endava.message;

import com.endava.entities.Client;
import com.endava.entities.Employee;

public class TransactionMessage extends Message {
    private String customerId;
    private String customerEmail;
    private int agentID;
    private String messageType;
    private int customerAccountID;
    private String transactionDate;
    private double transactionValue;
    private String transactionType;


    @Override
    public void constructMessage(Client customer, Employee agent) {

    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public int getAgentID() {
        return agentID;
    }

    public String getMessageType() {
        return messageType;
    }

    public int getCustomerAccountID() {
        return customerAccountID;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public double getTransactionValue() {
        return transactionValue;
    }

    public String getTransactionType() {
        return transactionType;
    }
}
