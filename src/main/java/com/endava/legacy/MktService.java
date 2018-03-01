package com.endava.legacy;

import com.endava.Entities.message.Subscriber;

/**
 * Created by gleon on 2/13/2018.
 */
public abstract class MktService implements Subscriber {
    public abstract void updateInformation(String customerID, Double transactionValue, String email);

    public abstract void sendAD(String CustomerID, String email);
}
