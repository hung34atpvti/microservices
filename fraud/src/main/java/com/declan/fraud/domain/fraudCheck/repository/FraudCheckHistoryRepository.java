package com.declan.fraud.domain.fraudCheck.repository;

import com.declan.fraud.domain.fraudCheck.model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
