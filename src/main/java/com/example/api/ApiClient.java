package com.example.api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.example.model.AbsLoginJsonResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;


public  class ApiClient {

    private static final HttpClient client = HttpClient.newHttpClient();
    private static String apiToken;
    private static String username;
    private static String password;
    private static String uri;

    public void setApiToken(String apiToken) {
        ApiClient.apiToken = apiToken;  // Store the API token for later use
    }
    public String getApiToken() {
        return ApiClient.apiToken; 
    }

    public static String getUsername() {
        return username;
    }
    public static void setUsername(String username) {
        ApiClient.username = username;
    }
    public static String getPassword() {
        return password;
    }
    public static void setPassword(String password) {
        ApiClient.password = password;
    }
    public static String getUri() {
        return uri;
    }
    public static void setUri(String uri) {
        ApiClient.uri = uri;
    }
    public static String login() 
        throws URISyntaxException, IOException, InterruptedException
    {
        // construct the req
        String r_LoginRequestBody  = String.format("{\"username\":\"%s\", \"password\":\"%s\"}", username, password);
        HttpRequest r_request  = HttpRequest.newBuilder()
                                .uri(new URI(uri))
                                .header("Content-Type", "application/json") 
                                .header("Accept", "application/json")       
                                .POST(HttpRequest.BodyPublishers.ofString(r_LoginRequestBody)) 
                                .build();
        // send the req
        HttpResponse<String> r_response = ApiClient.client.send(r_request, HttpResponse.BodyHandlers.ofString());
        // for debuggin
        System.out.println("------------------ status: " + r_response.statusCode());

        ObjectMapper r_objectMapper = new ObjectMapper();
        AbsLoginJsonResponse r_LoginResponse = r_objectMapper.readValue(r_response.body(), AbsLoginJsonResponse.class);
        apiToken = r_LoginResponse.getUser().getToken();
        List<String> r_LibrariesAbs = r_LoginResponse.getUser().getLibrariesAccessible();
        System.out.println("------------------ apiToken: " + apiToken);
        System.out.println("------------------ libraries ABS: " + r_LibrariesAbs);
        return apiToken;
    }

}
