package com.aks.core.facade;

import com.aks.core.data.DataManager;
import com.aks.core.service.PaymentService;
import com.aks.core.service.WalletService;
import com.aks.core.transport.HttpTransport;
import com.aks.core.util.JsonSerializer;

public class Pearly {
    private final PaymentService payments;
    private final WalletService wallet;
    public Pearly(){
        HttpTransport transport = new HttpTransport();
        JsonSerializer json = new JsonSerializer();
        DataManager dataManager = new DataManager();
        payments = new PaymentService(transport, json, dataManager);
        wallet = new WalletService();
    }
    public PaymentService payments(){return payments;}
    public WalletService wallet(){return wallet;}
}
