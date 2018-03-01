package com.endava.legacy;

import com.endava.Entities.message.Message;
import com.endava.Entities.message.TransactionMessage;

/**
 * Created by gleon on 2/13/2018.
 */
public class CuponMktService extends MktService {
    @Override
    public void updateInformation(String customerID, Double transactionValue, String email) {
        System.out.println("Check value :" + transactionValue);
        this.sendAD(customerID, email);
    }

    @Override
    public void notify(Message message) {
        sendAD(((TransactionMessage) message).getCustomerId(), ((TransactionMessage) message).getCustomerEmail());
    }

    public void sendAD(String CustomerID, String email) {
        System.out.println("Sending Coupons to customer "+ CustomerID +" with email " +email);
    }

}
