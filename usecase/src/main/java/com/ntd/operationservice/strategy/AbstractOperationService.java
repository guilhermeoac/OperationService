package com.ntd.operationservice.strategy;

import com.ntd.operationservice.OperationService;
import com.ntd.operationservice.dto.OperationDTO;
import com.ntd.operationservice.dto.OperationResultDTO;
import com.ntd.operationservice.exception.ApplicationException;
import java.math.BigDecimal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;

public abstract class AbstractOperationService implements OperationService {

    protected final Log logger = LogFactory.getLog(this.getClass());

    @Override
    public abstract OperationResultDTO execute(String firstParam, String secondParam);

    @Override
    public OperationDTO getOperationInfo(String type) {
        return null;
    }

    protected BigDecimal convertParameter(String parameter) {
        try {
            return new BigDecimal(parameter);
        } catch (Exception e) {
            logger.error("AbstractOperationService.convertParameter, message:" + e.getMessage(), e);
            throw new ApplicationException("invalid.parameter", "Invalid parameter!", HttpStatus.BAD_REQUEST);
        }
    }
}
