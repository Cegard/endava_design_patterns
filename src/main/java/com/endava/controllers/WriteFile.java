package com.endava.controllers;


import com.endava.message.Message;
import com.endava.message.TransactionMessage;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

public class WriteFile {
    public static void writeFile(Message message){
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        FileWriter fileWriter = null;
        PrintWriter pw = null;
        TransactionMessage transactionMessage = (TransactionMessage) message;
        String month = String.valueOf(gregorianCalendar.get(GregorianCalendar.MONTH)+1);
        String day = String.valueOf(gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH));
        String year = String.valueOf(gregorianCalendar.get(GregorianCalendar.YEAR));
        String fileName = "DEPOSITSTOREVIEW-"+"0"+month+"0"+day+year+".txt";
        try{
            fileWriter = new FileWriter(fileName, true);
            pw = new PrintWriter(fileWriter);
            pw.print(transactionMessage.getCustomerId()+", ");
            pw.print(transactionMessage.getCustomerAccountID()+", ");
            pw.println("$"+transactionMessage.getTransactionValue()+" USD");

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != fileWriter)
                    fileWriter.close();
                    pw.close();
            }catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
