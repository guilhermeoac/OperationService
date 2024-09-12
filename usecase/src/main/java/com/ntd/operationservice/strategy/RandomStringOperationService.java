package com.ntd.operationservice.strategy;

import com.ntd.operationservice.dto.OperationResultDTO;
import org.springframework.stereotype.Service;

@Service
public class RandomStringOperationService extends AbstractOperationService{
    @Override
    public OperationResultDTO execute(String firstParam, String secondParam) {
        return null;
    }
}
