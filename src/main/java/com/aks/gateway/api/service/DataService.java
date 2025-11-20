package com.aks.gateway.api.service;

import org.springframework.stereotype.Service;

import com.aks.core.data.DataEntry;
import com.aks.core.data.DataManager;

@Service
public class DataService {
    private final DataManager dataManager = new DataManager();

    public void saveDataEntry(DataEntry dataEntry) {
        dataManager.addData(dataEntry);
        dataManager.save();
    }
}
