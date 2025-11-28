package com.aks.core.facade;

import com.aks.core.data.DataManager;
import com.aks.core.service.PaymentService;
import com.aks.core.transport.HttpTransport;
import com.aks.core.util.JsonSerializer;

public class Pearly {
    private final PaymentService payments;
    public Pearly(){
        HttpTransport transport = new HttpTransport();
        JsonSerializer json = new JsonSerializer();
        DataManager dataManager = new DataManager();
        payments = new PaymentService(transport, json, dataManager);
    }
    public PaymentService payments(){return payments;}
}
