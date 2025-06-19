package com.financialtwin.service.impl;

import com.financialtwin.model.User;
import com.financialtwin.model.KYCStatus;
import com.financialtwin.repository.UserRepository;
import com.financialtwin.service.KYCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import jakarta.persistence.EntityNotFoundException;
import java.util.Arrays;
/*
@Service
public class KYCServiceImpl implements KYCService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User initiateKYC(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setKycStatus(KYCStatus.IN_PROGRESS);
        return userRepository.save(user);
    }

    @Override
    public User submitKYC(Long userId, MultipartFile[] documents) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        
        // Here you would typically:
        // 1. Validate the documents
        // 2. Store the documents securely
        // 3. Update the user's KYC status
        
        user.setKycStatus(KYCStatus.IN_PROGRESS);
        return userRepository.save(user);
    }

    @Override
    public User verifyKYC(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setKycStatus(KYCStatus.VERIFIED);
        return userRepository.save(user);
    }

    @Override
    public User rejectKYC(Long userId, String reason) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setKycStatus(KYCStatus.REJECTED);
        return userRepository.save(user);
    }

    @Override
    public KYCStatus getKYCStatus(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return user.getKycStatus();
    }
} */