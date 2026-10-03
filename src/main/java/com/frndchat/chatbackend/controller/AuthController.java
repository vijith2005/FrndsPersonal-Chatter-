package com.frndchat.chatbackend.controller;

import com.frndchat.chatbackend.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp(
            @RequestParam String email) {

        String otp = authService.generateOtp(email);

        return ResponseEntity.ok(
                "OTP sent successfully to " + email
        );
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(
            @RequestParam String email,
            @RequestParam String otp) {

        boolean verified =
                authService.verifyOtp(email, otp);

        if (verified) {

            return ResponseEntity.ok(
                    "OTP verified successfully for " + email
            );
        }

        return ResponseEntity.badRequest()
                .body("Invalid or expired OTP");
    }
}