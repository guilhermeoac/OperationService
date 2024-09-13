package com.ntd.operationservice.strategy;

import com.ntd.operationservice.OperationRepository;
import com.ntd.operationservice.dto.OperationResultDTO;
import org.springframework.stereotype.Service;

@Service
public class RandomStringOperationService extends AbstractOperationService{
    public RandomStringOperationService(OperationRepository operationRepository) {
        super(operationRepository);
    }

    @Override
    public OperationResultDTO execute(String firstParam, String secondParam) {
        return null;
    }
}
