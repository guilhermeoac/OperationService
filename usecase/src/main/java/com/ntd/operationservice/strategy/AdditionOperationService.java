package com.ntd.operationservice.strategy;

import com.ntd.operationservice.dto.OperationResultDTO;

public class AdditionOperationService extends AbstractOperationService{
    @Override
    public OperationResultDTO execute(String firstParam, String secondParam) {
        try {
            return new OperationResultDTO(convertParameter(firstParam).add(convertParameter(secondParam)).toString());
        } catch (Exception e) {
            logger.error("AdditionOperationService.execute, message:" + e.getMessage(), e);
            throw e;
        }
    }
}
