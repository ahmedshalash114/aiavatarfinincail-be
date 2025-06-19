package com.financialtwin.service.impl;

import com.financialtwin.model.KYCData;
import com.financialtwin.repository.KYCDataRepository;
import com.financialtwin.service.KYCDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class KYCDataServiceImpl implements KYCDataService {

    @Autowired
    private KYCDataRepository kycDataRepository;

    @Override
    public KYCData saveKYCData(KYCData kycData) {
        return kycDataRepository.save(kycData);
    }

    @Override
    public KYCData getKYCDataById(Long id) {
        return kycDataRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("KYC Data not found with id: " + id));
    }

    @Override
    public List<KYCData> getAllKYCData() {
        return kycDataRepository.findAll();
    }

    @Override
    public KYCData updateKYCData(Long id, KYCData kycData) {
        KYCData existingKYCData = getKYCDataById(id);
        
        // Update fields
        existingKYCData.setFullName(kycData.getFullName());
        existingKYCData.setEmail(kycData.getEmail());
        existingKYCData.setGender(kycData.getGender());
        existingKYCData.setAge(kycData.getAge());
        existingKYCData.setOccupation(kycData.getOccupation());
        existingKYCData.setMonthlyIncome(kycData.getMonthlyIncome());
        existingKYCData.setSavings(kycData.getSavings());
        existingKYCData.setInvestments(kycData.getInvestments());
        existingKYCData.setInvestmentGoal(kycData.getInvestmentGoal());
        existingKYCData.setRiskTolerance(kycData.getRiskTolerance());
        existingKYCData.setInvestmentTimeline(kycData.getInvestmentTimeline());
        existingKYCData.setShortTermGoal(kycData.getShortTermGoal());
        existingKYCData.setLongTermGoal(kycData.getLongTermGoal());
        existingKYCData.setInvestmentStyle(kycData.getInvestmentStyle());
        existingKYCData.setPreferredContact(kycData.getPreferredContact());
        existingKYCData.setProfileScore(kycData.getProfileScore());
        existingKYCData.setProfileRank(kycData.getProfileRank());
        existingKYCData.setCreatedByIp(kycData.getCreatedByIp());
        
        return kycDataRepository.save(existingKYCData);
    }

    @Override
    public void deleteKYCData(Long id) {
        if (!kycDataRepository.existsById(id)) {
            throw new EntityNotFoundException("KYC Data not found with id: " + id);
        }
        kycDataRepository.deleteById(id);
    }
} 