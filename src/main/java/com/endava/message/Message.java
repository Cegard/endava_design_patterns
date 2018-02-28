package com.endava.message;

import com.endava.entities.Client;
import com.endava.entities.Employee;

public abstract class Message {
    public abstract void constructMessage(Client customer, Employee agent);
}
