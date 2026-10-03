package com.frndchat.chatbackend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String senderId;

    private String receiverId;

    @Column(nullable = false)
    private String content;

    private LocalDateTime timestamp;

    private boolean read;

    public Message() {
    }

    // getters and setters
}