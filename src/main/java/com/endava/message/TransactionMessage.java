package com.endava.message;

import com.endava.entities.Client;
import com.endava.entities.Employee;

public class TransactionMessage extends Message {
    private int customerId;
    private String customerEmail;
    private int agentID;
    private String messageType;
    private int customerAccountID;
    private String transationDate;
    private double transactionValue;
    private String transationType;


    @Override
    public void constructMessage(Client customer, Employee agent) {

    }

    public int getCustomerId() {
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

    public String getTransationDate() {
        return transationDate;
    }

    public double getTransactionValue() {
        return transactionValue;
    }

    public String getTransationType() {
        return transationType;
    }
}
