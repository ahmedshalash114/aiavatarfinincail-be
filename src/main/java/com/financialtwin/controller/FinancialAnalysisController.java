package com.financialtwin.controller;

import com.financialtwin.model.FinancialProfile;
import com.financialtwin.service.FinancialAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
/*
@RestController
@RequestMapping("/api/v1/financial-analysis")
public class FinancialAnalysisController {

    @Autowired
    private FinancialAnalysisService financialAnalysisService;

    @PostMapping("/{userId}/analyze")
    public ResponseEntity<FinancialProfile> analyzeFinancialProfile(@PathVariable Long userId) {
        return ResponseEntity.ok(financialAnalysisService.analyzeFinancialProfile(userId));
    }

    @GetMapping("/{userId}/recommendations")
    public ResponseEntity<Map<String, Object>> getFinancialRecommendations(@PathVariable Long userId) {
        return ResponseEntity.ok(financialAnalysisService.getFinancialRecommendations(userId));
    }

    @GetMapping("/{userId}/suggestions")
    public ResponseEntity<List<String>> getImprovementSuggestions(@PathVariable Long userId) {
        return ResponseEntity.ok(financialAnalysisService.getImprovementSuggestions(userId));
    }

    @GetMapping("/{userId}/metrics")
    public ResponseEntity<Map<String, Object>> getFinancialHealthMetrics(@PathVariable Long userId) {
        return ResponseEntity.ok(financialAnalysisService.getFinancialHealthMetrics(userId));
    }
} */