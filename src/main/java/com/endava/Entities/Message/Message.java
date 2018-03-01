package com.endava.Entities.Message;

import com.endava.Entities.Client;
import com.endava.Entities.Employees.Employee;

public abstract class Message {

    public abstract void constructMessage(Client customer, Employee agent);
}
