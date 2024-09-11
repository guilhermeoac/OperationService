package com.ntd.operationservice.strategy;

import com.ntd.operationservice.OperationService;
import com.ntd.operationservice.dto.OperationDTO;
import com.ntd.operationservice.dto.OperationResultDTO;

public abstract class AbstractOperationService implements OperationService {

    @Override
    public abstract OperationResultDTO execute(String type, String firstParam, String secondParam);

    @Override
    public OperationDTO getOperationInfo(String type) {
        return null;
    }
}
