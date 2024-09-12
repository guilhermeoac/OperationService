package com.ntd.operationservice.strategy;

import com.ntd.operationservice.exception.ApplicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SquareRootOperationServiceTest {

    private SquareRootOperationService squareRootOperationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        squareRootOperationService = new SquareRootOperationService();
    }

    @Test
    void should_execute_sum_correct() {
        var response = squareRootOperationService.execute("1", "2");

        assertEquals(response.result(), "1");
    }

    @Test
    void should_execute_sum_decimal_correct() {
        var response = squareRootOperationService.execute("1.2", null);

        assertEquals(response.result(), "1.44");
    }

    @Test
    void should_execute_sum_negative_correct() {
        var response = squareRootOperationService.execute("-1.2", "asdas");

        assertEquals(response.result(), "1.44");
    }

    @Test
    void should_throw_exception_when_first_parameter_is_null() {
        var exception = assertThrows(ApplicationException.class, () -> squareRootOperationService.execute(null, "2.2"));

        assertEquals(exception.getCode(), "first.param.invalid");
    }

    @Test
    void should_throw_exception_when_first_parameter_is_word() {
        var exception = assertThrows(ApplicationException.class, () -> squareRootOperationService.execute("asda", "2.2"));

        assertEquals(exception.getCode(), "first.param.invalid");
    }
}