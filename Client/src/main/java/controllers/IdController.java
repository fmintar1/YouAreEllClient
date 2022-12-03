package controllers;
import java.util.ArrayList;
import java.util.HashMap;
import models.Id;

public class IdController {
    private HashMap<String, Id> allIds = new HashMap<>();
    Id myId;
    public ArrayList<Id> getIds() {
        ArrayList<Id> result = new ArrayList<>();
        for(String i : this.allIds.keySet())
            result.add(allIds.get(i));
        return result;
    }

    public String postId(Id id) {
        return ServerController.shared().idPost(id);
        // create json from id
        // call server, get json result Or error
        // result json to Id obj
    }

    public Id putId(Id id) {
        return null;
    }
 
}