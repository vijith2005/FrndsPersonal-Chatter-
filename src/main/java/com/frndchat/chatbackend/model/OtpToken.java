package com.frndchat.chatbackend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "otp_tokens")
public class OtpToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String otp;

    private LocalDateTime createdAt;

    private LocalDateTime expiresAt;

    private boolean verified;

    public OtpToken() {
    }

    public OtpToken(String email, String otp) {
        this.email = email;
        this.otp = otp;
    }

    public OtpToken(String email,
                    String otp,
                    LocalDateTime createdAt,
                    LocalDateTime expiresAt,
                    boolean verified) {

        this.email = email;
        this.otp = otp;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.verified = verified;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}