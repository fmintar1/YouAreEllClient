package controllers;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

public class MessageController {
    private String rootURL = "http://zipcode.rocks:8085";
    private ObjectMapper mapper = new ObjectMapper();

    private HashSet<Message> messagesSeen;
    // why a HashSet??

    public ArrayList<Message> getMessages() {
        String urlMessageGet = ServerController.apiGet("/messages");
        try {
            return mapper.readValue(urlMessageGet, new TypeReference<>() {});
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
//    public HashSet<Message> getMessages() {}
    public HashSet<Message> getMessagesForId(Id Id) {
        return null;
    }
    public Message getMessageForSequence(String seq) {
        return null;
    }
    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
        return null;
    }

    public Message postMessage(Message message) {
        try {
            String temp = mapper.writeValueAsString(message);
            String temp2 = ServerController.apiPost("/ids/Freddy_Mintarja/messages", temp);
            return mapper.readValue(temp2, Message.class);
//            return mapper.readValue(ServerController.apiPost("/ids/Freddy_Mintarja/message",mapper.writeValueAsString(message)), Message.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
        }
 
}