package com.ntd.operationservice;

import com.ntd.operationservice.dto.OperationDTO;
import com.ntd.operationservice.dto.OperationResultDTO;

public interface OperationService {

    OperationResultDTO execute(String firstParam, String secondParam);

    OperationDTO getOperationInfo(String type);
}
