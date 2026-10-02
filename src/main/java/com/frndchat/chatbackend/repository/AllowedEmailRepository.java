package com.frndchat.chatbackend.repository;

import com.frndchat.chatbackend.model.AllowedEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AllowedEmailRepository extends JpaRepository<AllowedEmail, Long> {

    Optional<AllowedEmail> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByEmailAndAllowedTrue(String email);
}