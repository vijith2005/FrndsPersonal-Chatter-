package com.frndchat.chatbackend.service;

import com.frndchat.chatbackend.model.OtpToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final OtpService otpService;

    public AuthService(OtpService otpService) {
        this.otpService = otpService;
    }

    public String generateOtp(String email) {
        OtpToken otpToken = otpService.createOtp(email);
        System.out.println(
                "OTP for " + email + " : " + otpToken.getOtp()
        );

        return otpToken.getOtp();
    }

    public boolean verifyOtp(String email, String enteredOtp) {
        return otpService.verifyOtp(email, enteredOtp);
    }
}