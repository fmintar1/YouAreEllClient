package controllers;

//import spiffyUrlManipulator
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class ServerController {
    private final String rootURL = "http://zipcode.rocks:8085";
    private static final ServerController svr = new ServerController();
    private ServerController() {}

    public static ServerController shared() {
        return svr;
    }
    public String idGet() {
        try {
            String temp = rootURL + "/ids";
            URL url = new URL(temp);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(temp))
                    .build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
        catch (Exception e) {
            return "Exception Error!";
        }
        // url -> /ids/
        // send the server a get with url
        // return json from server
    }
    public String idPost(Id id) {
        var values = new HashMap<String, String>() {{
            put ("userid", "-");
            put ("name", id.getName());
            put ("github", id.getGithub());
        }};

        var objectMapper = new ObjectMapper();

        try {
            String requestBody = objectMapper
                    .writeValueAsString(values);
            String temp = rootURL + "/ids";
            URL url = new URL(temp);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(temp))
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            return response.body();
        }
        catch (Exception e) {
            return "Exception Error!";
        }
        // url -> /ids/
        // create json from Id
        // request
        // reply
        // return json
    }
//    public JsonString idPut(Id) {
//        String temp = rootURL + "/ids/";
//        // url -> /ids/
//    }
}
// ServerController.shared.doGet()