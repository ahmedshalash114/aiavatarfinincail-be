package com.financialtwin.controller;

import com.financialtwin.service.AIFinancialAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
/*
@RestController
@RequestMapping("/api/v1/ai-analysis")
public class AIFinancialAnalysisController {

    @Autowired
    private AIFinancialAnalysisService aiFinancialAnalysisService;

    @GetMapping("/{userId}/stability")
    public ResponseEntity<Map<String, Object>> analyzeFinancialStability(@PathVariable Long userId) {
        return ResponseEntity.ok(aiFinancialAnalysisService.analyzeFinancialStability(userId));
    }

    @GetMapping("/{userId}/recommendations")
    public ResponseEntity<List<String>> getPersonalizedRecommendations(@PathVariable Long userId) {
        return ResponseEntity.ok(aiFinancialAnalysisService.generatePersonalizedRecommendations(userId));
    }

    @GetMapping("/{userId}/ranking")
    public ResponseEntity<Map<String, Object>> getFinancialRanking(@PathVariable Long userId) {
        return ResponseEntity.ok(aiFinancialAnalysisService.calculateFinancialRanking(userId));
    }

    @GetMapping("/{userId}/trends")
    public ResponseEntity<Map<String, Object>> predictFinancialTrends(@PathVariable Long userId) {
        return ResponseEntity.ok(aiFinancialAnalysisService.predictFinancialTrends(userId));
    }

    @GetMapping("/{userId}/insights")
    public ResponseEntity<List<String>> getActionableInsights(@PathVariable Long userId) {
        return ResponseEntity.ok(aiFinancialAnalysisService.getActionableInsights(userId));
    }
} */