package com.frndchat.chatbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "allowed_emails")
public class AllowedEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    public AllowedEmail() {
    }

    public AllowedEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}