package com.ntd.operationservice.strategy;

import com.ntd.operationservice.exception.ApplicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AdditionOperationServiceTest {

    private AdditionOperationService additionOperationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        additionOperationService = new AdditionOperationService();
    }

    @Test
    void should_execute_sum_correct() {
        var response = additionOperationService.execute("1", "2");

        assertEquals(response.result(), "3");
    }

    @Test
    void should_execute_sum_decimal_correct() {
        var response = additionOperationService.execute("1.2", "2.2");

        assertEquals(response.result(), "3.4");
    }

    @Test
    void should_execute_sum_negative_correct() {
        var response = additionOperationService.execute("-1.2", "2.2");

        assertEquals(response.result(), "1");
    }

    @Test
    void should_throw_exception_when_first_parameter_is_null() {
        var exception = assertThrows(ApplicationException.class, () -> additionOperationService.execute(null, "2.2"));

        assertEquals(exception.getCode(), "first.param.invalid");
    }

    @Test
    void should_throw_exception_when_first_parameter_is_word() {
        var exception = assertThrows(ApplicationException.class, () -> additionOperationService.execute("asda", "2.2"));

        assertEquals(exception.getCode(), "first.param.invalid");
    }

    @Test
    void should_throw_exception_when_second_parameter_is_null() {
        var exception = assertThrows(ApplicationException.class, () -> additionOperationService.execute("1", null));

        assertEquals(exception.getCode(), "second.param.invalid");
    }

    @Test
    void should_throw_exception_when_second_parameter_is_word() {
        var exception = assertThrows(ApplicationException.class, () -> additionOperationService.execute("1", "2.1as2"));

        assertEquals(exception.getCode(), "second.param.invalid");
    }
}