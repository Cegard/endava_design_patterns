package com.endava.message;

public interface MessageService {
    public void addSubscriber(Subscriber subscriber);
    public void removeSubscriber(Subscriber subscriber);
    public void notifySubscribers(Message message);
}
