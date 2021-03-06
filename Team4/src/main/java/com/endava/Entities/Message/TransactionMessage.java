package com.endava.Entities.Message;

import com.endava.Entities.Client;
import com.endava.Entities.Employees.Employee;

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
        this.customerId = String.valueOf(customer.getCustomerID());
        this.customerEmail = customer.getCustomerEmail();
        this.agentID = agent.getId();
        this.messageType = "Transaction Message";
        this.customerAccountID = customer.getAccountID();
        this.transactionDate = customer.getTransaction().getOperationDate();
        this.transactionValue = customer.getTransaction().getOperationValue();
        this.transactionType = customer.getTransaction().getTypeOperation();
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
