package com.endava.Operations;

import com.endava.message.Message;
import com.endava.message.Subscriber;
import com.endava.message.TransactionMessage;

public class AuditModule implements Subscriber {
    @Override
    public void notify(Message message) {
        TransactionMessage transactionMessage = (TransactionMessage) message;
        System.out.println("El modulo de auditoria ha sido notificado: "+transactionMessage.getTransationType());
    }
}
