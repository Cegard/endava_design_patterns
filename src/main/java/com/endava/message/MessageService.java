package com.endava.message;

import com.endava.entities.Client;
import com.endava.entities.Employee;

public interface MessageService {
    public void addSubscriber(Subscriber subscriber);
    public void removeSubscriber(Subscriber subscriber);
    public void notifySubscribers(Message message);
    public void createMessage (Client customer, Employee agent);
}
