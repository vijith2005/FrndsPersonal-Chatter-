package com.frndchat.chatbackend.model;

public class AllowedEmail {

    private String id;
    private String email;
    private boolean allowed;

    public AllowedEmail() {
    }

    public AllowedEmail(String id, String email, boolean allowed) {
        this.id = id;
        this.email = email;
        this.allowed = allowed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAllowed() {
        return allowed;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }
}