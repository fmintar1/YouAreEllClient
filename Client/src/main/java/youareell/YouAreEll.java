package youareell;
import controllers.*;

import java.io.IOException;

public class YouAreEll {
    TransactionController tt;
    public YouAreEll (TransactionController t) {
        this.tt = t;
    }
    public static void main(String[] args) {
        // hmm: is this Dependency Injection?
        YouAreEll urlhandler = new YouAreEll(
            new TransactionController(
                new MessageController(), new IdController()
        ));
        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }

    public String get_ids() {
        return tt.makecall("/ids", "GET", "");
    }
    public String post_id(String name, String github) {
        return tt.postId(name, github);
    }

    public String get_messages() {
        return MakeURLCall("/messages", "GET", "");
    }
    private String MakeURLCall(String s, String get, String s1) {
        return s + " " + get + " " + s1;
    }
}