package com.financialtwin.controller;

import com.financialtwin.dto.KYCDataRequest;
import com.financialtwin.dto.KYCDataResponse;
import com.financialtwin.model.KYCData;
import com.financialtwin.service.KYCDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/kyc-data")
@CrossOrigin(origins = "https://wealthmindai.netlify.app/*")
public class KYCDataController {

    @Autowired
    private KYCDataService kycDataService;

    @PostMapping
    public ResponseEntity<KYCDataResponse> createKYCData(
            @Valid @RequestBody KYCDataRequest request,
            HttpServletRequest httpRequest) {
        
        // Convert DTO to entity
        KYCData kycData = convertToEntity(request);
        
        // Set the IP address of the client
        String clientIp = getClientIpAddress(httpRequest);
        kycData.setCreatedByIp(clientIp);
        
        KYCData savedKYCData = kycDataService.saveKYCData(kycData);
        KYCDataResponse response = convertToResponse(savedKYCData);
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KYCDataResponse> getKYCDataById(@PathVariable Long id) {
        KYCData kycData = kycDataService.getKYCDataById(id);
        KYCDataResponse response = convertToResponse(kycData);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<KYCDataResponse>> getAllKYCData() {
        List<KYCData> kycDataList = kycDataService.getAllKYCData();
        List<KYCDataResponse> responses = kycDataList.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KYCDataResponse> updateKYCData(
            @PathVariable Long id,
            @Valid @RequestBody KYCDataRequest request) {
        
        KYCData kycData = convertToEntity(request);
        KYCData updatedKYCData = kycDataService.updateKYCData(id, kycData);
        KYCDataResponse response = convertToResponse(updatedKYCData);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKYCData(@PathVariable Long id) {
        kycDataService.deleteKYCData(id);
        return ResponseEntity.noContent().build();
    }

    private KYCData convertToEntity(KYCDataRequest request) {
        KYCData kycData = new KYCData();
        kycData.setFullName(request.getFullName());
        kycData.setEmail(request.getEmail());
        kycData.setGender(request.getGender());
        kycData.setAge(request.getAge());
        kycData.setOccupation(request.getOccupation());
        kycData.setMonthlyIncome(request.getMonthlyIncome());
        kycData.setSavings(request.getSavings());
        kycData.setInvestments(request.getInvestments());
        kycData.setInvestmentGoal(request.getInvestmentGoal());
        kycData.setRiskTolerance(request.getRiskTolerance());
        kycData.setInvestmentTimeline(request.getInvestmentTimeline());
        kycData.setShortTermGoal(request.getShortTermGoal());
        kycData.setLongTermGoal(request.getLongTermGoal());
        kycData.setInvestmentStyle(request.getInvestmentStyle());
        kycData.setPreferredContact(request.getPreferredContact());
        kycData.setProfileScore(request.getProfileScore());
        kycData.setProfileRank(request.getProfileRank());
        return kycData;
    }

    private KYCDataResponse convertToResponse(KYCData kycData) {
        KYCDataResponse response = new KYCDataResponse();
        response.setId(kycData.getId());
        response.setFullName(kycData.getFullName());
        response.setEmail(kycData.getEmail());
        response.setGender(kycData.getGender());
        response.setAge(kycData.getAge());
        response.setOccupation(kycData.getOccupation());
        response.setMonthlyIncome(kycData.getMonthlyIncome());
        response.setSavings(kycData.getSavings());
        response.setInvestments(kycData.getInvestments());
        response.setInvestmentGoal(kycData.getInvestmentGoal());
        response.setRiskTolerance(kycData.getRiskTolerance());
        response.setInvestmentTimeline(kycData.getInvestmentTimeline());
        response.setShortTermGoal(kycData.getShortTermGoal());
        response.setLongTermGoal(kycData.getLongTermGoal());
        response.setInvestmentStyle(kycData.getInvestmentStyle());
        response.setPreferredContact(kycData.getPreferredContact());
        response.setProfileScore(kycData.getProfileScore());
        response.setProfileRank(kycData.getProfileRank());
        response.setCreatedByIp(kycData.getCreatedByIp());
        response.setCreatedAt(kycData.getCreatedAt());
        response.setUpdatedAt(kycData.getUpdatedAt());
        return response;
    }

    private String getClientIpAddress(HttpServletRequest request) {
        String xForwardedFor = request.getHeader("X-Forwarded-For");
        if (xForwardedFor != null && !xForwardedFor.isEmpty() && !"unknown".equalsIgnoreCase(xForwardedFor)) {
            return xForwardedFor.split(",")[0];
        }
        
        String xRealIp = request.getHeader("X-Real-IP");
        if (xRealIp != null && !xRealIp.isEmpty() && !"unknown".equalsIgnoreCase(xRealIp)) {
            return xRealIp;
        }
        
        return request.getRemoteAddr();
    }
} 