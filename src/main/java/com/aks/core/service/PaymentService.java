package com.aks.core.service;

import com.aks.core.data.DataEntry;
import com.aks.core.data.DataManager;
import com.aks.core.factory.TransactionServiceFactory;
import com.aks.core.model.WalletInfo;
import com.aks.core.transport.HttpTransport;
import com.aks.core.util.JsonSerializer;
import com.aks.core.util.Status;
import java.util.List;
/*
    -This class is all about payments I receive to
    generated wallet that I have saved in a DB/json file.

    -It has nothing to do with signing or broadcasting any crypto transactions.
 */
public class PaymentService {
    private final HttpTransport transport;
    private final DataManager dataManager;
    private List<DataEntry> pending;
    private final JsonSerializer json;

    public PaymentService(HttpTransport transport, JsonSerializer json, DataManager dataManager){
        this.transport = transport;
        this.dataManager = dataManager;
        this.json = json;
    }
    public void addPayment(DataEntry dataEntry){
        dataManager.addData(dataEntry);
    }
    public void addPendingPayments(){
        pending = dataManager.getData().stream()
                .filter(d -> d.getStatus() == Status.PENDING)
                .toList();
    }
    public void checkPendingPayments(){
        // get all PENDING wallets from json file
        addPendingPayments();
        TransactionService transactionService;
        for(DataEntry d : pending){
            transactionService = TransactionServiceFactory.create(d.getTicker(), transport, json);
            if(transactionService.isPaid(d)){
                System.out.println("received " + d.getTicker().toUpperCase() +
                        " payment on: " + d.getWalletAddress());
                d.setStatus(Status.COMPLETE);
            }else{
                System.out.println("not sent yet!");
            }
        }
        dataManager.save();
    }
}
