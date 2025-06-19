package com.financialtwin.service;

import com.financialtwin.model.User;
import com.financialtwin.model.KYCStatus;
import org.springframework.web.multipart.MultipartFile;

public interface KYCService {
    User initiateKYC(Long userId);
    User submitKYC(Long userId, MultipartFile[] documents);
    User verifyKYC(Long userId);
    User rejectKYC(Long userId, String reason);
    KYCStatus getKYCStatus(Long userId);
} 