package com.frndchat.chatbackend.repository;

import com.frndchat.chatbackend.model.AllowedEmail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AllowedEmailRepository
        extends JpaRepository<AllowedEmail, Long> {

    Optional<AllowedEmail> findByEmail(String email);

    boolean existsByEmail(String email);
}