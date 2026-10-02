package com.frndchat.chatbackend.repository;

import com.frndchat.chatbackend.model.OtpToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpTokenRepository extends JpaRepository<OtpToken, Long> {

    Optional<OtpToken> findTopByEmailOrderByCreatedAtDesc(String email);

    Optional<OtpToken> findByEmailAndOtp(String email, String otp);

    boolean existsByEmail(String email);
}