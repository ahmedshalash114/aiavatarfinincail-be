package com.financialtwin.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class KYCDataRequest {
    
    @NotBlank(message = "Full name is required")
    @Size(max = 255, message = "Full name must not exceed 255 characters")
    private String fullName;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be a valid email address")
    @Size(max = 255, message = "Email must not exceed 255 characters")
    private String email;
    
    @Size(max = 10, message = "Gender must not exceed 10 characters")
    private String gender;
    
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 120, message = "Age must not exceed 120")
    private Integer age;
    
    @Size(max = 255, message = "Occupation must not exceed 255 characters")
    private String occupation;
    
    @DecimalMin(value = "0.0", inclusive = false, message = "Monthly income must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Monthly income must have at most 10 digits before decimal and 2 after")
    private BigDecimal monthlyIncome;
    
    @DecimalMin(value = "0.0", inclusive = true, message = "Savings must be non-negative")
    @Digits(integer = 10, fraction = 2, message = "Savings must have at most 10 digits before decimal and 2 after")
    private BigDecimal savings;
    
    @DecimalMin(value = "0.0", inclusive = true, message = "Investments must be non-negative")
    @Digits(integer = 10, fraction = 2, message = "Investments must have at most 10 digits before decimal and 2 after")
    private BigDecimal investments;
    
    @Size(max = 50, message = "Investment goal must not exceed 50 characters")
    private String investmentGoal;
    
    @Size(max = 20, message = "Risk tolerance must not exceed 20 characters")
    private String riskTolerance;
    
    @Size(max = 50, message = "Investment timeline must not exceed 50 characters")
    private String investmentTimeline;
    
    @Size(max = 255, message = "Short term goal must not exceed 255 characters")
    private String shortTermGoal;
    
    @Size(max = 255, message = "Long term goal must not exceed 255 characters")
    private String longTermGoal;
    
    @Size(max = 50, message = "Investment style must not exceed 50 characters")
    private String investmentStyle;
    
    @Size(max = 50, message = "Preferred contact must not exceed 50 characters")
    private String preferredContact;
    
    @Min(value = 0, message = "Profile score must be non-negative")
    @Max(value = 100, message = "Profile score must not exceed 100")
    private Integer profileScore;
    
    @Size(max = 50, message = "Profile rank must not exceed 50 characters")
    private String profileRank;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(BigDecimal monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public BigDecimal getSavings() {
        return savings;
    }

    public void setSavings(BigDecimal savings) {
        this.savings = savings;
    }

    public BigDecimal getInvestments() {
        return investments;
    }

    public void setInvestments(BigDecimal investments) {
        this.investments = investments;
    }

    public String getInvestmentGoal() {
        return investmentGoal;
    }

    public void setInvestmentGoal(String investmentGoal) {
        this.investmentGoal = investmentGoal;
    }

    public String getRiskTolerance() {
        return riskTolerance;
    }

    public void setRiskTolerance(String riskTolerance) {
        this.riskTolerance = riskTolerance;
    }

    public String getInvestmentTimeline() {
        return investmentTimeline;
    }

    public void setInvestmentTimeline(String investmentTimeline) {
        this.investmentTimeline = investmentTimeline;
    }

    public String getShortTermGoal() {
        return shortTermGoal;
    }

    public void setShortTermGoal(String shortTermGoal) {
        this.shortTermGoal = shortTermGoal;
    }

    public String getLongTermGoal() {
        return longTermGoal;
    }

    public void setLongTermGoal(String longTermGoal) {
        this.longTermGoal = longTermGoal;
    }

    public String getInvestmentStyle() {
        return investmentStyle;
    }

    public void setInvestmentStyle(String investmentStyle) {
        this.investmentStyle = investmentStyle;
    }

    public String getPreferredContact() {
        return preferredContact;
    }

    public void setPreferredContact(String preferredContact) {
        this.preferredContact = preferredContact;
    }

    public Integer getProfileScore() {
        return profileScore;
    }

    public void setProfileScore(Integer profileScore) {
        this.profileScore = profileScore;
    }

    public String getProfileRank() {
        return profileRank;
    }

    public void setProfileRank(String profileRank) {
        this.profileRank = profileRank;
    }
}