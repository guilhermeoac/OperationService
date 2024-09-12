package com.ntd.operationservice.strategy;

import com.ntd.operationservice.dto.OperationResultDTO;
import com.ntd.operationservice.exception.ApplicationException;
import java.math.RoundingMode;
import org.springframework.http.HttpStatus;

public class DivisionOperationService extends AbstractOperationService{
    @Override
    public OperationResultDTO execute(String firstParam, String secondParam) {
        try {
            return new OperationResultDTO(convertParameter(firstParam).setScale(5, RoundingMode.HALF_UP).divide(convertParameter(secondParam), RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP).toString());
        } catch (ArithmeticException e) {
            logger.error("SquareRootOperationService.execute, ArithmeticException message:" + e.getMessage(), e);
            throw new ApplicationException("invalid.operation.param", e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("DivisionOperationService.execute, message:" + e.getMessage(), e);
            throw e;
        }
    }
}
