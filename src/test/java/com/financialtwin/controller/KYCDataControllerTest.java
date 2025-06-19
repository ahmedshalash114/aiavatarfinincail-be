package com.financialtwin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.financialtwin.dto.KYCDataRequest;
import com.financialtwin.model.KYCData;
import com.financialtwin.service.KYCDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(KYCDataController.class)
public class KYCDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KYCDataService kycDataService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateKYCData_Success() throws Exception {
        // Given
        KYCDataRequest request = new KYCDataRequest();
        request.setFullName("John Doe");
        request.setEmail("john.doe@example.com");
        request.setGender("Male");
        request.setAge(30);
        request.setOccupation("Software Engineer");
        request.setMonthlyIncome(new BigDecimal("5000.00"));
        request.setSavings(new BigDecimal("25000.00"));
        request.setInvestments(new BigDecimal("15000.00"));
        request.setInvestmentGoal("Retirement");
        request.setRiskTolerance("Moderate");
        request.setInvestmentTimeline("10-15 years");
        request.setShortTermGoal("Emergency fund");
        request.setLongTermGoal("Financial independence");
        request.setInvestmentStyle("Diversified");
        request.setPreferredContact("Email");
        request.setProfileScore(75);
        request.setProfileRank("Gold");

        KYCData savedKYCData = new KYCData();
        savedKYCData.setId(1L);
        savedKYCData.setFullName("John Doe");
        savedKYCData.setEmail("john.doe@example.com");
        savedKYCData.setGender("Male");
        savedKYCData.setAge(30);
        savedKYCData.setOccupation("Software Engineer");
        savedKYCData.setMonthlyIncome(new BigDecimal("5000.00"));
        savedKYCData.setSavings(new BigDecimal("25000.00"));
        savedKYCData.setInvestments(new BigDecimal("15000.00"));
        savedKYCData.setInvestmentGoal("Retirement");
        savedKYCData.setRiskTolerance("Moderate");
        savedKYCData.setInvestmentTimeline("10-15 years");
        savedKYCData.setShortTermGoal("Emergency fund");
        savedKYCData.setLongTermGoal("Financial independence");
        savedKYCData.setInvestmentStyle("Diversified");
        savedKYCData.setPreferredContact("Email");
        savedKYCData.setProfileScore(75);
        savedKYCData.setProfileRank("Gold");
        savedKYCData.setCreatedByIp("127.0.0.1");
        savedKYCData.setCreatedAt(LocalDateTime.now());
        savedKYCData.setUpdatedAt(LocalDateTime.now());

        when(kycDataService.saveKYCData(any(KYCData.class))).thenReturn(savedKYCData);

        // When & Then
        mockMvc.perform(post("/api/v1/kyc-data")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.fullName").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$.gender").value("Male"))
                .andExpect(jsonPath("$.age").value(30))
                .andExpect(jsonPath("$.occupation").value("Software Engineer"))
                .andExpect(jsonPath("$.monthlyIncome").value(5000.00))
                .andExpect(jsonPath("$.savings").value(25000.00))
                .andExpect(jsonPath("$.investments").value(15000.00))
                .andExpect(jsonPath("$.investmentGoal").value("Retirement"))
                .andExpect(jsonPath("$.riskTolerance").value("Moderate"))
                .andExpect(jsonPath("$.investmentTimeline").value("10-15 years"))
                .andExpect(jsonPath("$.shortTermGoal").value("Emergency fund"))
                .andExpect(jsonPath("$.longTermGoal").value("Financial independence"))
                .andExpect(jsonPath("$.investmentStyle").value("Diversified"))
                .andExpect(jsonPath("$.preferredContact").value("Email"))
                .andExpect(jsonPath("$.profileScore").value(75))
                .andExpect(jsonPath("$.profileRank").value("Gold"));
    }

    @Test
    public void testCreateKYCData_ValidationError() throws Exception {
        // Given - Invalid request with missing required fields
        KYCDataRequest request = new KYCDataRequest();
        request.setAge(15); // Invalid age (less than 18)

        // When & Then
        mockMvc.perform(post("/api/v1/kyc-data")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Validation Error"))
                .andExpect(jsonPath("$.details.fullName").value("Full name is required"))
                .andExpect(jsonPath("$.details.email").value("Email is required"))
                .andExpect(jsonPath("$.details.age").value("Age must be at least 18"));
    }
} 