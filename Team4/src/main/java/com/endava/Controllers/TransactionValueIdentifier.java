package com.endava.Controllers;

import com.endava.Entities.Message.Message;
import com.endava.Entities.Message.TransactionMessage;

public class TransactionValueIdentifier extends AuditControl {
    private AuditControl nextAuditControl;
    private double evaluateValue = 10000;
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
        if(transactionMessage.getTransactionValue()>=evaluateValue){
            WriteFile.writeFile(message);
        }
    }
}
