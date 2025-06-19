package com.financialtwin.repository;

import com.financialtwin.model.FinancialProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FinancialProfileRepository extends JpaRepository<FinancialProfile, Long> {
    Optional<FinancialProfile> findByUserId(Long userId);
} 