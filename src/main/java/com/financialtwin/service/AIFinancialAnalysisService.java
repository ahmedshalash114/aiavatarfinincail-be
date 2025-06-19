package com.financialtwin.service;

import com.financialtwin.model.FinancialProfile;
import java.util.Map;
import java.util.List;

public interface AIFinancialAnalysisService {
    Map<String, Object> analyzeFinancialStability(Long userId);
    List<String> generatePersonalizedRecommendations(Long userId);
    Map<String, Object> calculateFinancialRanking(Long userId);
    Map<String, Object> predictFinancialTrends(Long userId);
    List<String> getActionableInsights(Long userId);
} 