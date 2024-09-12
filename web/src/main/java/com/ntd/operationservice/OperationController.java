package com.ntd.operationservice;

import com.ntd.operationservice.dto.OperationParamsDTO;
import com.ntd.operationservice.dto.OperationResultDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/operation")
public class OperationController {

    private final OperationsFactory operationsFactory;

    public OperationController(OperationsFactory operationsFactory) {
        this.operationsFactory = operationsFactory;
    }

    @PostMapping("/execute")
    public ResponseEntity<OperationResultDTO> executeOperation(
            @RequestHeader("type") String type,
            @RequestBody OperationParamsDTO body
            ) {
        return ResponseEntity.ok(operationsFactory.getInstance(type).execute(body.firstParam(), body.secondParam()));
    }
}


