package com.criptocoinstests.criptotests.service;
import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.util.MultiValueMap;
import org.json.JSONObject;
@Service
public class CriptoService {


    public ResponseEntity<String> searchCripto(){
        String url = "https://api.coingecko.com/api/v3/search?query=ethereum";
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request= HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JSONObject jsonResponse = new JSONObject(response.body());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        return new ResponseEntity<>(jsonResponse.toString(),  headers,HttpStatus.OK);
    }
}
