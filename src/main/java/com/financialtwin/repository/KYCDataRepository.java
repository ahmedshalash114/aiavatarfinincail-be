package com.financialtwin.repository;

import com.financialtwin.model.KYCData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KYCDataRepository extends JpaRepository<KYCData, Long> {
    // Custom query methods can be added here if needed
} 