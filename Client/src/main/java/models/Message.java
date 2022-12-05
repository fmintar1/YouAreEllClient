package models;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/*
 * POJO for an Message object
 *
 *   {
    "sequence": "-",
    "timestamp": "_",
    "fromid": "xt0fer",
    "toid": "kristofer",
    "message": "Hello, Kristofer!"
  },

*
 */
public class Message implements Comparable {
    @JsonProperty("message")
    private String message = "";
    @JsonProperty("toid")
    private String toId = "";
    @JsonProperty("fromid")
    private String fromId = "";
    @JsonProperty("timestamp")
    private String timestamp = "";
    @JsonProperty("sequence")
    private String seqId = "";

    public Message() {
    }
    public Message (String message, String fromId, String toId) {
        this(message, fromId, toId, null, "");
    }
    public Message (String message, String fromId) {
        this(message, fromId, "", null, "");
    }
    public Message (String message, String fromId, String toId, String timestamp, String seqId) {
        this.message = message;
        this.fromId = fromId;
        this.toId = toId;
        this.timestamp = timestamp;
        this.seqId = seqId;
    }
    public int compareTo(Object o) {
        return this.seqId.compareTo(((Message) o).getSeqId());
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSeqId() {
        return seqId;
    }
    @Override
    public String toString() {
        return new StringBuilder()
                .append("\n{")
                .append("\n\tSequence: " + this.seqId)
                .append("\n\tTime Stamp: " + this.timestamp)
                .append("\n\tFrom ID: " + this.fromId)
                .append("\n\tTo ID: " + this.toId)
                .append("\n\tMessage " + this.message)
                .append("\n}")
                .toString();
    }
}