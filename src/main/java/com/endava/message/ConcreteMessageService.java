package com.endava.message;

import com.endava.entities.Client;
import com.endava.entities.Employees.Employee;

import java.util.Vector;

public class ConcreteMessageService implements MessageService {

    private Vector<Subscriber> subscribers = new Vector<>();

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Message message) {
        for(Subscriber sub : subscribers){
            sub.notify(message);
        }
    }

    @Override
    public void createMessage(Client customer, Employee agent) {
        Message transactionMessage = new TransactionMessage();
        transactionMessage.constructMessage(customer,agent);
        notifySubscribers(transactionMessage);
    }



}
