package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * POJO for an Id object
 */
public class Id {
    @JsonProperty("userid")
    private String uid = "";
    @JsonIgnoreProperties
    private String name = "";
    private String github = "";

    public Id() {
    }
    public Id(String name, String githubId) {
        this("", name, githubId);
    }
    public Id (String uid, String name, String githubId) {
        this.uid = uid;
        this.name = name;
        this.github = githubId;
    }
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGithub() {
        return github;
    }
    public void setGithub(String github) {
        this.github = github;
    }
    @Override
    public String toString() {
        return new StringBuilder()
                .append("\n{")
                .append("\n\tuserid: " + this.uid)
                .append("\n\tname: " + this.name)
                .append("\n\tgithub: " + this.github)
                .append("\n},")
                .toString();
    }
}