package com.learnkorealanguage.app.service;

import java.net.http.HttpClient;

public class APIServices {
    private final HttpClient client;
    private static APIServices instance = null;
    private APIServices(){
        client = HttpClient.newHttpClient();
    }

    public static APIServices getInstance(){
        if (instance == null){
            instance = new APIServices();
        }
        return instance;
    }

    public HttpClient getHttpClient(){
        return client;
    }

}
