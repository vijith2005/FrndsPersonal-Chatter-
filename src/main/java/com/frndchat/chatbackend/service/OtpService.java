package com.frndchat.chatbackend.service;

import com.frndchat.chatbackend.model.OtpToken;
import com.frndchat.chatbackend.repository.OtpTokenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class OtpService {

    private final OtpTokenRepository otpTokenRepository;

    public OtpService(OtpTokenRepository otpTokenRepository) {
        this.otpTokenRepository = otpTokenRepository;
    }

    public String generateOtp() {

        Random random = new Random();

        int otp = 100000 + random.nextInt(900000);

        return String.valueOf(otp);
    }

    public OtpToken createOtp(String email) {

        String otp = generateOtp();

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime expiresAt = now.plusMinutes(5);

        OtpToken otpToken = new OtpToken(
                email,
                otp,
                now,
                expiresAt,
                false
        );

        return otpTokenRepository.save(otpToken);
    }

    public boolean verifyOtp(String email, String enteredOtp) {

        OtpToken otpToken = otpTokenRepository
                .findTopByEmailOrderByCreatedAtDesc(email)
                .orElseThrow(() ->
                        new IllegalArgumentException("OTP not found")
                );

        if (otpToken.isVerified()) {
            throw new IllegalArgumentException("OTP already used");
        }

        if (otpToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("OTP expired");
        }

        if (!otpToken.getOtp().equals(enteredOtp)) {
            throw new IllegalArgumentException("Invalid OTP");
        }

        otpToken.setVerified(true);

        otpTokenRepository.save(otpToken);

        return true;
    }
}