package com.financialtwin.service.impl;

import com.financialtwin.model.FinancialProfile;
import com.financialtwin.model.RiskLevel;
import com.financialtwin.repository.FinancialProfileRepository;
import com.financialtwin.service.FinancialAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;
/*
@Service
public class FinancialAnalysisServiceImpl implements FinancialAnalysisService {

    @Autowired
    private FinancialProfileRepository financialProfileRepository;

    @Override
    public FinancialProfile analyzeFinancialProfile(Long userId) {
        FinancialProfile profile = financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Financial profile not found"));

        // Calculate financial health score (0-100)
        int healthScore = calculateFinancialHealthScore(profile);
        profile.setFinancialHealthScore(healthScore);

        // Determine risk level
        RiskLevel riskLevel = determineRiskLevel(profile);
        profile.setRiskLevel(riskLevel);

        profile.setLastAnalysisDate(LocalDateTime.now());
        return financialProfileRepository.save(profile);
    }

    @Override
    public Map<String, Object> getFinancialRecommendations(Long userId) {
        FinancialProfile profile = financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Financial profile not found"));

        Map<String, Object> recommendations = new HashMap<>();
        
        // Calculate debt-to-income ratio
        BigDecimal debtToIncomeRatio = profile.getTotalLiabilities()
                .divide(profile.getMonthlyIncome(), 2, RoundingMode.HALF_UP);
        
        // Calculate savings rate
        BigDecimal savingsRate = profile.getMonthlyIncome()
                .subtract(profile.getMonthlyExpenses())
                .divide(profile.getMonthlyIncome(), 2, RoundingMode.HALF_UP)
                .multiply(new BigDecimal("100"));

        recommendations.put("debtToIncomeRatio", debtToIncomeRatio);
        recommendations.put("savingsRate", savingsRate);
        recommendations.put("riskLevel", profile.getRiskLevel());
        recommendations.put("financialHealthScore", profile.getFinancialHealthScore());

        return recommendations;
    }

    @Override
    public List<String> getImprovementSuggestions(Long userId) {
        FinancialProfile profile = financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Financial profile not found"));

        List<String> suggestions = new ArrayList<>();

        // Analyze savings rate
        BigDecimal savingsRate = profile.getMonthlyIncome()
                .subtract(profile.getMonthlyExpenses())
                .divide(profile.getMonthlyIncome(), 2, RoundingMode.HALF_UP)
                .multiply(new BigDecimal("100"));

        if (savingsRate.compareTo(new BigDecimal("20")) < 0) {
            suggestions.add("Consider increasing your monthly savings rate to at least 20% of your income");
        }

        // Analyze debt-to-income ratio
        BigDecimal debtToIncomeRatio = profile.getTotalLiabilities()
                .divide(profile.getMonthlyIncome(), 2, RoundingMode.HALF_UP);

        if (debtToIncomeRatio.compareTo(new BigDecimal("0.36")) > 0) {
            suggestions.add("Your debt-to-income ratio is high. Consider paying down debt to improve your financial health");
        }

        // Analyze credit score
        if (profile.getCreditScore() < 700) {
            suggestions.add("Work on improving your credit score by paying bills on time and reducing credit utilization");
        }

        return suggestions;
    }

    @Override
    public Map<String, Object> getFinancialHealthMetrics(Long userId) {
        FinancialProfile profile = financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Financial profile not found"));

        Map<String, Object> metrics = new HashMap<>();
        metrics.put("creditScore", profile.getCreditScore());
        metrics.put("monthlyIncome", profile.getMonthlyIncome());
        metrics.put("monthlyExpenses", profile.getMonthlyExpenses());
        metrics.put("totalAssets", profile.getTotalAssets());
        metrics.put("totalLiabilities", profile.getTotalLiabilities());
        metrics.put("financialHealthScore", profile.getFinancialHealthScore());
        metrics.put("riskLevel", profile.getRiskLevel());
        metrics.put("lastAnalysisDate", profile.getLastAnalysisDate());

        return metrics;
    }

    private int calculateFinancialHealthScore(FinancialProfile profile) {
        int score = 0;
        
        // Credit score component (40% weight)
        score += (profile.getCreditScore() * 0.4);
        
        // Savings rate component (30% weight)
        BigDecimal savingsRate = profile.getMonthlyIncome()
                .subtract(profile.getMonthlyExpenses())
                .divide(profile.getMonthlyIncome(), 2, RoundingMode.HALF_UP)
                .multiply(new BigDecimal("100"));
        score += (savingsRate.intValue() * 0.3);
        
        // Debt-to-income ratio component (30% weight)
        BigDecimal debtToIncomeRatio = profile.getTotalLiabilities()
                .divide(profile.getMonthlyIncome(), 2, RoundingMode.HALF_UP);
        int debtScore = 100 - (debtToIncomeRatio.multiply(new BigDecimal("100")).intValue());
        score += (debtScore * 0.3);
        
        return Math.min(100, Math.max(0, score));
    }

    private RiskLevel determineRiskLevel(FinancialProfile profile) {
        int healthScore = profile.getFinancialHealthScore();
        
        if (healthScore >= 80) return RiskLevel.VERY_LOW;
        if (healthScore >= 60) return RiskLevel.LOW;
        if (healthScore >= 40) return RiskLevel.MODERATE;
        if (healthScore >= 20) return RiskLevel.HIGH;
        return RiskLevel.VERY_HIGH;
    }
} */