package com.financialtwin.service;

import com.financialtwin.model.KYCData;
import java.util.List;

public interface KYCDataService {
    KYCData saveKYCData(KYCData kycData);
    KYCData getKYCDataById(Long id);
    List<KYCData> getAllKYCData();
    KYCData updateKYCData(Long id, KYCData kycData);
    void deleteKYCData(Long id);
} 