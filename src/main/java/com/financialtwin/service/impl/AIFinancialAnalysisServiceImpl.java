package com.financialtwin.service.impl;

import com.financialtwin.model.FinancialProfile;
import com.financialtwin.model.RiskLevel;
import com.financialtwin.repository.FinancialProfileRepository;
import com.financialtwin.service.AIFinancialAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;
/*
@Service
public class AIFinancialAnalysisServiceImpl implements AIFinancialAnalysisService {

    @Autowired
    private FinancialProfileRepository financialProfileRepository;

    @Override
    public Map<String, Object> analyzeFinancialStability(Long userId) {
        FinancialProfile profile = financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Financial profile not found"));

        Map<String, Object> analysis = new HashMap<>();
        
        // Calculate key financial ratios
        BigDecimal debtToIncomeRatio = calculateDebtToIncomeRatio(profile);
        BigDecimal savingsRate = calculateSavingsRate(profile);
        BigDecimal emergencyFundRatio = calculateEmergencyFundRatio(profile);
        BigDecimal investmentRatio = calculateInvestmentRatio(profile);
        
        // Determine financial stability score (0-100)
        int stabilityScore = calculateStabilityScore(profile, debtToIncomeRatio, savingsRate, 
                                                   emergencyFundRatio, investmentRatio);
        
        analysis.put("stabilityScore", stabilityScore);
        analysis.put("debtToIncomeRatio", debtToIncomeRatio);
        analysis.put("savingsRate", savingsRate);
        analysis.put("emergencyFundRatio", emergencyFundRatio);
        analysis.put("investmentRatio", investmentRatio);
        analysis.put("riskLevel", determineRiskLevel(stabilityScore));
        analysis.put("analysisDate", LocalDateTime.now());
        
        return analysis;
    }

    @Override
    public List<String> generatePersonalizedRecommendations(Long userId) {
        FinancialProfile profile = financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Financial profile not found"));

        List<String> recommendations = new ArrayList<>();
        Map<String, Object> stability = analyzeFinancialStability(userId);
        int stabilityScore = (int) stability.get("stabilityScore");
        
        // Generate recommendations based on stability score and financial metrics
        if (stabilityScore < 40) {
            recommendations.add("CRITICAL: Focus on building an emergency fund of at least 3 months of expenses");
            recommendations.add("URGENT: Reduce high-interest debt as a top priority");
            recommendations.add("IMPORTANT: Create a strict budget to control expenses");
        } else if (stabilityScore < 60) {
            recommendations.add("PRIORITY: Increase your emergency fund to 6 months of expenses");
            recommendations.add("CONSIDER: Start investing in low-risk assets");
            recommendations.add("PLAN: Develop a debt reduction strategy");
        } else if (stabilityScore < 80) {
            recommendations.add("OPTIMIZE: Diversify your investment portfolio");
            recommendations.add("ENHANCE: Consider tax-efficient investment strategies");
            recommendations.add("GROW: Look for opportunities to increase your income");
        } else {
            recommendations.add("MAINTAIN: Continue your current financial practices");
            recommendations.add("ADVANCE: Consider advanced investment strategies");
            recommendations.add("LEGACY: Plan for wealth preservation and transfer");
        }

        return recommendations;
    }

    @Override
    public Map<String, Object> calculateFinancialRanking(Long userId) {
        FinancialProfile profile = financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Financial profile not found"));

        Map<String, Object> ranking = new HashMap<>();
        
        // Calculate percentile rankings for different metrics
        int creditScoreRank = calculatePercentileRank(profile.getCreditScore(), 300, 850);
        int savingsRateRank = calculatePercentileRank(
            calculateSavingsRate(profile).multiply(new BigDecimal("100")).intValue(), 0, 100);
        int debtToIncomeRank = calculatePercentileRank(
            calculateDebtToIncomeRatio(profile).multiply(new BigDecimal("100")).intValue(), 0, 100);
        
        // Calculate overall financial ranking
        int overallRank = (creditScoreRank + savingsRateRank + debtToIncomeRank) / 3;
        
        ranking.put("overallRank", overallRank);
        ranking.put("creditScoreRank", creditScoreRank);
        ranking.put("savingsRateRank", savingsRateRank);
        ranking.put("debtToIncomeRank", debtToIncomeRank);
        ranking.put("rankingCategory", determineRankingCategory(overallRank));
        
        return ranking;
    }

    @Override
    public Map<String, Object> predictFinancialTrends(Long userId) {
        FinancialProfile profile = financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Financial profile not found"));

        Map<String, Object> predictions = new HashMap<>();
        
        // Predict future financial metrics based on current data
        BigDecimal projectedSavings = predictFutureSavings(profile);
        BigDecimal projectedNetWorth = predictFutureNetWorth(profile);
        int projectedCreditScore = predictFutureCreditScore(profile);
        
        predictions.put("projectedSavings", projectedSavings);
        predictions.put("projectedNetWorth", projectedNetWorth);
        predictions.put("projectedCreditScore", projectedCreditScore);
        predictions.put("timeframe", "12 months");
        predictions.put("confidenceLevel", calculatePredictionConfidence(profile));
        
        return predictions;
    }

    @Override
    public List<String> getActionableInsights(Long userId) {
        FinancialProfile profile = financialProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Financial profile not found"));

        List<String> insights = new ArrayList<>();
        Map<String, Object> stability = analyzeFinancialStability(userId);
        Map<String, Object> ranking = calculateFinancialRanking(userId);
        
        // Generate specific actionable insights
        if (profile.getCreditScore() < 700) {
            insights.add("Your credit score is below optimal. Focus on paying bills on time and reducing credit utilization.");
        }
        
        BigDecimal savingsRate = calculateSavingsRate(profile);
        if (savingsRate.compareTo(new BigDecimal("0.20")) < 0) {
            insights.add("Your savings rate is below the recommended 20%. Consider automating monthly savings transfers.");
        }
        
        BigDecimal debtToIncomeRatio = calculateDebtToIncomeRatio(profile);
        if (debtToIncomeRatio.compareTo(new BigDecimal("0.36")) > 0) {
            insights.add("Your debt-to-income ratio is high. Prioritize paying down high-interest debt.");
        }
        
        return insights;
    }

    private BigDecimal calculateDebtToIncomeRatio(FinancialProfile profile) {
        return profile.getTotalLiabilities()
                .divide(profile.getMonthlyIncome(), 2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateSavingsRate(FinancialProfile profile) {
        return profile.getMonthlyIncome()
                .subtract(profile.getMonthlyExpenses())
                .divide(profile.getMonthlyIncome(), 2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateEmergencyFundRatio(FinancialProfile profile) {
        BigDecimal monthlyExpenses = profile.getMonthlyExpenses();
        BigDecimal emergencyFund = profile.getTotalAssets()
                .subtract(profile.getTotalLiabilities());
        return emergencyFund.divide(monthlyExpenses, 2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateInvestmentRatio(FinancialProfile profile) {
        return profile.getTotalAssets()
                .subtract(profile.getTotalLiabilities())
                .divide(profile.getTotalAssets(), 2, RoundingMode.HALF_UP);
    }

    private int calculateStabilityScore(FinancialProfile profile, 
                                      BigDecimal debtToIncomeRatio,
                                      BigDecimal savingsRate,
                                      BigDecimal emergencyFundRatio,
                                      BigDecimal investmentRatio) {
        int score = 0;
        
        // Credit score component (30%)
        score += (profile.getCreditScore() * 0.3);
        
        // Savings rate component (25%)
        score += (savingsRate.multiply(new BigDecimal("100")).intValue() * 0.25);
        
        // Debt-to-income ratio component (25%)
        int debtScore = 100 - (debtToIncomeRatio.multiply(new BigDecimal("100")).intValue());
        score += (debtScore * 0.25);
        
        // Emergency fund component (10%)
        int emergencyScore = Math.min(100, emergencyFundRatio.multiply(new BigDecimal("20")).intValue());
        score += (emergencyScore * 0.1);
        
        // Investment ratio component (10%)
        score += (investmentRatio.multiply(new BigDecimal("100")).intValue() * 0.1);
        
        return Math.min(100, Math.max(0, score));
    }

    private RiskLevel determineRiskLevel(int stabilityScore) {
        if (stabilityScore >= 80) return RiskLevel.VERY_LOW;
        if (stabilityScore >= 60) return RiskLevel.LOW;
        if (stabilityScore >= 40) return RiskLevel.MODERATE;
        if (stabilityScore >= 20) return RiskLevel.HIGH;
        return RiskLevel.VERY_HIGH;
    }

    private int calculatePercentileRank(int value, int min, int max) {
        return (int) (((double) (value - min) / (max - min)) * 100);
    }

    private String determineRankingCategory(int rank) {
        if (rank >= 90) return "EXCELLENT";
        if (rank >= 75) return "VERY_GOOD";
        if (rank >= 60) return "GOOD";
        if (rank >= 40) return "FAIR";
        return "NEEDS_IMPROVEMENT";
    }

    private BigDecimal predictFutureSavings(FinancialProfile profile) {
        BigDecimal currentSavings = profile.getTotalAssets().subtract(profile.getTotalLiabilities());
        BigDecimal monthlySavings = profile.getMonthlyIncome().subtract(profile.getMonthlyExpenses());
        return currentSavings.add(monthlySavings.multiply(new BigDecimal("12")));
    }

    private BigDecimal predictFutureNetWorth(FinancialProfile profile) {
        BigDecimal currentNetWorth = profile.getTotalAssets().subtract(profile.getTotalLiabilities());
        BigDecimal monthlySavings = profile.getMonthlyIncome().subtract(profile.getMonthlyExpenses());
        return currentNetWorth.add(monthlySavings.multiply(new BigDecimal("12")));
    }

    private int predictFutureCreditScore(FinancialProfile profile) {
        int currentScore = profile.getCreditScore();
        if (currentScore < 700) {
            return Math.min(850, currentScore + 50);
        }
        return Math.min(850, currentScore + 20);
    }

    private double calculatePredictionConfidence(FinancialProfile profile) {
        // Calculate confidence based on data quality and completeness
        double confidence = 0.8; // Base confidence
        
        if (profile.getCreditScore() == null) confidence -= 0.1;
        if (profile.getMonthlyIncome() == null) confidence -= 0.1;
        if (profile.getMonthlyExpenses() == null) confidence -= 0.1;
        if (profile.getTotalAssets() == null) confidence -= 0.1;
        if (profile.getTotalLiabilities() == null) confidence -= 0.1;
        
        return Math.max(0.5, confidence);
    }
} */