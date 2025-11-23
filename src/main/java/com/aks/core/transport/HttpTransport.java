package com.aks.core.transport;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class HttpTransport {

    private final HttpClient client;
    public HttpTransport(){
        this.client = HttpClient.newHttpClient();
    }

    public String get(String url, Map<String, String> headers){

        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(URI.create(url));
        // add headers if needed
        if(headers != null) headers.forEach(requestBuilder::headers);
        HttpRequest request = requestBuilder.build();

        try{
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
        catch(Exception e){
            System.err.println("GET request error" + e);
        }
        return "";
    }
}
