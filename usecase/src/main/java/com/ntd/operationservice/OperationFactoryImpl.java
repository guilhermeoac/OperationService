package com.ntd.operationservice;

import com.ntd.operation.OperationTypeEnum;
import com.ntd.operationservice.strategy.AdditionOperationService;
import com.ntd.operationservice.strategy.DivisionOperationService;
import com.ntd.operationservice.strategy.MultiplyOperationService;
import com.ntd.operationservice.strategy.RandomStringOperationService;
import com.ntd.operationservice.strategy.SquareRootOperationService;
import com.ntd.operationservice.strategy.SubtractionOperationService;

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

        return switch(OperationTypeEnum.valueOf(type)) {
            case RANDOM_STRING -> randomStringOperationService;
            case ADDITION -> additionOperationService;
            case SUBTRACTION -> subtractionOperationService;
            case DIVISION -> divisionOperationService;
            case SQUARE_ROOT -> squareRootOperationService;
            case MULTIPLY -> multiplyOperationService;
            default -> throw new RuntimeException("operation.not.register");
        };

    }
}
