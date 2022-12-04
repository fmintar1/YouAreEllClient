package controllers;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServerController {
    private static final String rootURL = "http://zipcode.rocks:8085";
    private static final ServerController svr = new ServerController();
    private ServerController() {}
    public static ServerController shared() {
        return svr;
    }
    public static String apiGet(String extension) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(rootURL + extension))
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
    public static String apiPost(String extension, String jsonType) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(rootURL + extension))
                    .POST(HttpRequest.BodyPublishers.ofString(jsonType))
                    .build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
        catch (Exception e) {
            return "Exception Error!";
        }
//        var values = new HashMap<String, String>() {{
//            put ("userid", "-");
//            put ("name", id.getName());
//            put ("github", id.getGithub());
//        }};
//        var objectMapper = new ObjectMapper();
//        try {
//            String requestBody = objectMapper
//                    .writeValueAsString(values);
//            String temp = rootURL + "/ids";
//            URL url = new URL(temp);
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(temp))
//                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                    .build();
//            HttpResponse<String> response = client.send(request,
//                    HttpResponse.BodyHandlers.ofString());
//            return response.body();
//        }
//        catch (Exception e) {
//            return "Exception Error!";
//        }
        // url -> /ids/
        // create json from Id
        // request
        // reply
        // return json
    }
//    public String idPut(Id) {
//        String temp = rootURL + "/ids/";
//        // url -> /ids/
//    }
}
// ServerController.shared.doGet()