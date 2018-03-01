package com.endava.Controllers;

import com.endava.Entities.Message.Message;

public abstract class AuditControl {
    public abstract void setNext (AuditControl auditControl);
    public abstract AuditControl getNext();
    public abstract void analyseTransactionMessage (Message message);
}
