/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.webclient1.client_rest;

import java.io.IOException;
import java.io.InputStream;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author andre
 */
public class SomaClientRest {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/webservice1/resources/calculadora/soma";

//    public SomaClientRest() {
//        client = javax.ws.rs.client.ClientBuilder.newClient();
//        webTarget = client.target(BASE_URI).path("soma");
//    }
    
    public String getSoma(int num1, int num2) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpUriRequest httpUriRequest = new HttpGet(BASE_URI + "/" + num1 + "/" + num2);

        HttpResponse response = client.execute(httpUriRequest);
        HttpEntity entity = response.getEntity();
        String restValue = EntityUtils.toString(response.getEntity());
        
        return restValue;
    }
}
