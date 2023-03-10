package com.declan.fraud.domain.fraudCheck.service.impl;

import com.declan.fraud.domain.fraudCheck.model.FraudCheckHistory;
import com.declan.fraud.domain.fraudCheck.repository.FraudCheckHistoryRepository;
import com.declan.fraud.domain.fraudCheck.service.FraudCheckService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckServiceImpl implements FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    @Override
    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
