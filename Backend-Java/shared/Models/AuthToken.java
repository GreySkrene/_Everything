package edu.byu.cs.tweeter.model.domain;

import java.io.Serializable;

public class AuthToken implements Serializable {

    public String token;
    public String datetime;

    public AuthToken() {
    }

    public AuthToken(String token) {
        this.token = token;
    }

    public AuthToken(String token, String datetime) {
        this.token = token;
        this.datetime = datetime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}