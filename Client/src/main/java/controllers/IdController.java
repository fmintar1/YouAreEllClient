package controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

public class IdController {

    private ObjectMapper mapper = new ObjectMapper();

    private HashMap<String, Id> allIds = new HashMap<>();
    Id myId;
    public ArrayList<Id> getIds() {
        String urlIdGet = ServerController.apiGet("/ids");
        try {
            return mapper.readValue(urlIdGet, new TypeReference<>() {});
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public Id postId(Id id) {
//        return ServerController.shared().apiPost("/ids", id.getName());
//    }
        try {
            String temp = mapper.writeValueAsString(id);
            String temp2 = ServerController.apiPost("/ids", temp);
            return mapper.readValue(temp2, Id.class);
//            return mapper.readValue(ServerController.apiPost("/ids/Freddy_Mintarja/message",mapper.writeValueAsString(message)), Message.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
        // create json from id
        // call server, get json result Or error
        // result json to Id obj

    public Id putId(Id id) {
        return null;
    }
 
}