package com.endava.controllers;

import com.endava.message.Message;
import com.endava.message.Subscriber;
import com.endava.message.TransactionMessage;

public class AuditModule extends AuditControl implements Subscriber  {
    private AuditControl nextAuditControl;

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
        TransactionIdentifier transactionIdentifier = new TransactionIdentifier();
        this.setNext(transactionIdentifier);

        TransactionValueIdentifier transactionValueIdentifier = new TransactionValueIdentifier();
        this.setNext(transactionValueIdentifier);

        nextAuditControl.analyseTransactionMessage(message);
    }

    @Override
    public void notify(Message message) {
        TransactionMessage transactionMessage = (TransactionMessage) message;
        analyseTransactionMessage(transactionMessage);
    }

}
