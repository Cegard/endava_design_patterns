package com.endava.Entities.message;

import com.endava.Entities.Client;
import com.endava.Entities.Employees.Employee;

public interface MessageService {
    public void addSubscriber(Subscriber subscriber);
    public void removeSubscriber(Subscriber subscriber);
    public void notifySubscribers(Message message);
    public void createMessage (Client customer, Employee agent);
}
