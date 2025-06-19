package com.financialtwin.controller;

import com.financialtwin.model.User;
import com.financialtwin.model.KYCStatus;
import com.financialtwin.service.KYCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
/*
@RestController
@RequestMapping("/api/v1/kyc")
public class KYCController {

    @Autowired
    private KYCService kycService;

    @PostMapping("/{userId}/initiate")
    public ResponseEntity<User> initiateKYC(@PathVariable Long userId) {
        return ResponseEntity.ok(kycService.initiateKYC(userId));
    }

    @PostMapping("/{userId}/submit")
    public ResponseEntity<User> submitKYC(
            @PathVariable Long userId,
            @RequestParam("documents") MultipartFile[] documents) {
        return ResponseEntity.ok(kycService.submitKYC(userId, documents));
    }

    @PostMapping("/{userId}/verify")
    public ResponseEntity<User> verifyKYC(@PathVariable Long userId) {
        return ResponseEntity.ok(kycService.verifyKYC(userId));
    }

    @PostMapping("/{userId}/reject")
    public ResponseEntity<User> rejectKYC(
            @PathVariable Long userId,
            @RequestParam String reason) {
        return ResponseEntity.ok(kycService.rejectKYC(userId, reason));
    }

    @GetMapping("/{userId}/status")
    public ResponseEntity<KYCStatus> getKYCStatus(@PathVariable Long userId) {
        return ResponseEntity.ok(kycService.getKYCStatus(userId));
    }
}

 */