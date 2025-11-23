package com.aks.transport;
import com.aks.core.transport.HttpTransport;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TransportTest {
    private static HttpTransport transport;
    @BeforeAll
    static void initAll(){
        transport = new HttpTransport();
    }
    @AfterAll
    static void tearDownAll(){
        transport = null;
    }
    @Test
    void testGetRequest(){
        // url to check assets in a bitcoin address
        String url = "https://blockstream.info/api/address/bc1qv7a4m25wr6zyvg09v2mclfz9f2q25ep5lhcf6j";
        String response = transport.get(url, null);
        System.out.println(response);
    }
}
