package com.ntd.operationservice.strategy;

import com.ntd.operationservice.dto.OperationResultDTO;

public class SubtractionOperationService extends AbstractOperationService{
    @Override
    public OperationResultDTO execute(String firstParam, String secondParam) {
        try {
            return new OperationResultDTO(convertParameter(firstParam).subtract(convertParameter(secondParam)).toString());
        } catch (Exception e) {
            logger.error("SubtractionOperationService.execute, message:" + e.getMessage(), e);
            throw e;
        }
    }
}
