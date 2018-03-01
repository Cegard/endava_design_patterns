package com.endava.controllers;

import com.endava.message.Message;

public abstract class AuditControl {
    public abstract void setNext (AuditControl auditControl);
    public abstract AuditControl getNext();
    public abstract void analyseTransactionMessage (Message message);
}
