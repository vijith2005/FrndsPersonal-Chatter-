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

        String token = authService.generateOtpToken(email);

        return ResponseEntity.ok(token);
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(
            @RequestParam String token,
            @RequestParam String otp) {

        boolean verified = authService.verifyOtp(token, otp);

        if (verified) {
            String email = authService.getEmailFromOtpToken(token);

            return ResponseEntity.ok(
                    "OTP verified successfully for " + email
            );
        }

        return ResponseEntity.badRequest()
                .body("Invalid or expired OTP");
    }
}