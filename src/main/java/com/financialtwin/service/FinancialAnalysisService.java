package com.financialtwin.service;

import com.financialtwin.model.FinancialProfile;
import java.util.List;
import java.util.Map;

public interface FinancialAnalysisService {
    FinancialProfile analyzeFinancialProfile(Long userId);
    Map<String, Object> getFinancialRecommendations(Long userId);
    List<String> getImprovementSuggestions(Long userId);
    Map<String, Object> getFinancialHealthMetrics(Long userId);
} 