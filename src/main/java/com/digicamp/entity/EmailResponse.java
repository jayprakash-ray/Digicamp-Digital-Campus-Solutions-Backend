package com.digicamp.entity;

public class EmailResponse {
    String token;

    public EmailResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}