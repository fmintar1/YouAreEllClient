package controllers;
import models.Id;
import models.Message;

import java.util.List;
public class TransactionController {
    private String rootURL = "http://zipcode.rocks:8085";
    private MessageController msgCtrl;
    private IdController idCtrl;
    public TransactionController(MessageController m, IdController j) {
        this.msgCtrl = m;
        this.idCtrl = j;
    }
    public List<Id> getIds() {
        return idCtrl.getIds();
    }
    public List<Message> getMessages() {
        return msgCtrl.getMessages();
    }
    public String postId(String idtoRegister, String githubName) {
        Id tid = new Id(idtoRegister, githubName);
        idCtrl.postId(tid);
        return ("Id registered.");
    }
    public String makecall(String s, String get, String s1) {
        return ServerController.shared().apiGet(get);
    }
    public String postGlobalMessage(String sender, String message) {
        Message mid = new Message(message, sender);
        msgCtrl.postMessage(mid);
        return ("Message sent globally");
    }
    public String postMessageToFriend(String sender, String message, String friend) {
        Message mid = new Message(message, sender, friend);
        msgCtrl.postMessage(mid);
        return ("Message sent to " + friend);
    }
}