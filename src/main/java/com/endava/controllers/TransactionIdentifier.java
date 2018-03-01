package com.endava.controllers;

import com.endava.message.Message;
import com.endava.message.TransactionMessage;

public class TransactionIdentifier extends AuditControl {
    private AuditControl nextAuditControl;
    private String evaluateTransactionType = "DEPOSIT";

    @Override
    public void setNext(AuditControl auditControl) {
        nextAuditControl = auditControl;
    }

    @Override
    public AuditControl getNext() {
        return nextAuditControl;
    }

    @Override
    public void analyseTransactionMessage(Message message) {
        TransactionMessage transactionMessage = (TransactionMessage) message;
        if(transactionMessage.getTransactionType().equalsIgnoreCase(evaluateTransactionType)){
            nextAuditControl.analyseTransactionMessage(message);
        }
    }
}
