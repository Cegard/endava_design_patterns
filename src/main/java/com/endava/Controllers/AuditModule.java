package com.endava.Controllers;

import com.endava.Entities.message.Message;
import com.endava.Entities.message.Subscriber;
import com.endava.Entities.message.TransactionMessage;

public class AuditModule implements Subscriber {
    @Override
    public void notify(Message message) {
        TransactionMessage transactionMessage = (TransactionMessage) message;
        System.out.println("El modulo de auditoria ha sido notificado: "+transactionMessage.getTransactionType());
        System.out.println("El modulo de auditoria ha sido notificado en la fecha: "+transactionMessage.getTransactionDate());
    }
}
