package com.ntd.operationservice;

import com.ntd.operation.OperationTypeEnum;
import com.ntd.operationservice.exception.ApplicationException;
import com.ntd.operationservice.strategy.AdditionOperationService;
import com.ntd.operationservice.strategy.DivisionOperationService;
import com.ntd.operationservice.strategy.MultiplyOperationService;
import com.ntd.operationservice.strategy.RandomStringOperationService;
import com.ntd.operationservice.strategy.SquareRootOperationService;
import com.ntd.operationservice.strategy.SubtractionOperationService;
import org.springframework.http.HttpStatus;

public class OperationFactoryImpl implements OperationsFactory{

    private final AdditionOperationService additionOperationService;
    private final DivisionOperationService divisionOperationService;
    private final MultiplyOperationService multiplyOperationService;
    private final RandomStringOperationService randomStringOperationService;
    private final SquareRootOperationService squareRootOperationService;
    private final SubtractionOperationService subtractionOperationService;

    public OperationFactoryImpl(AdditionOperationService additionOperationService, DivisionOperationService divisionOperationService, MultiplyOperationService multiplyOperationService, RandomStringOperationService randomStringOperationService, SquareRootOperationService squareRootOperationService, SubtractionOperationService subtractionOperationService) {
        this.additionOperationService = additionOperationService;
        this.divisionOperationService = divisionOperationService;
        this.multiplyOperationService = multiplyOperationService;
        this.randomStringOperationService = randomStringOperationService;
        this.squareRootOperationService = squareRootOperationService;
        this.subtractionOperationService = subtractionOperationService;
    }

    @Override
    public OperationService getInstance(String type) {

        if (OperationTypeEnum.RANDOM_STRING.name().equals(type)) {
            return randomStringOperationService;
        } else if (OperationTypeEnum.ADDITION.name().equals(type)) {
            return additionOperationService;
        } else if (OperationTypeEnum.SUBTRACTION.name().equals(type)) {
            return subtractionOperationService;
        } else if (OperationTypeEnum.DIVISION.name().equals(type)) {
            return divisionOperationService;
        } else if (OperationTypeEnum.SQUARE_ROOT.name().equals(type)) {
            return squareRootOperationService;
        } else if (OperationTypeEnum.MULTIPLY.name().equals(type)) {
            return multiplyOperationService;
        } else {
            throw new ApplicationException("operation.not.register", "Operation is not registered!", HttpStatus.BAD_REQUEST);
        }

    }
}
