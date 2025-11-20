package com.aks.data;

import com.aks.core.data.DataManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DataManagerTest {
    private static DataManager dataManager;
    @BeforeAll
    static void initAll(){
        dataManager = new DataManager();
    }
    @AfterAll
    static void tearDownAll(){
        dataManager = null;
    }
    @Test
    void fileExists(){
        assertTrue(dataManager.dataFileExists());
    }

}
