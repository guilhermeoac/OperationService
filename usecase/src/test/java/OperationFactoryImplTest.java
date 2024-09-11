import com.ntd.operationservice.OperationFactoryImpl;
import com.ntd.operationservice.OperationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OperationFactoryImplTest {

    private final OperationFactoryImpl operationFactory = new OperationFactoryImpl();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void should_return_addition_operation() {
        OperationService result = operationFactory.getInstance("ADDITION");

        assertEquals(result instanceof AdditionOperationImpl);
    }

    @Test
    void should_return_subtraction_operation() {
        OperationService result = operationFactory.getInstance("SUBTRACTION");

        assertEquals(result instanceof SubtractionOperationImpl);
    }

    @Test
    void should_return_multiply_operation() {
        OperationService result = operationFactory.getInstance("MULTIPLY");

        assertEquals(result instanceof MultiplyOperationImpl);
    }

    @Test
    void should_return_division_operation() {
        OperationService result = operationFactory.getInstance("DIVISION");

        assertEquals(result instanceof DivisionOperationImpl);
    }

    @Test
    void should_return_square_root_operation() {
        OperationService result = operationFactory.getInstance("SQUARE_ROOT");

        assertEquals(result instanceof SquareRootOperationImpl);
    }

    @Test
    void should_return_random_string_operation() {
        OperationService result = operationFactory.getInstance("RANDOM_STRING");

        assertEquals(result instanceof RandomStringOperationImpl);
    }

    @Test
    void should_return_error_to_operation_null() {
        assertThrows(Exception.class, () -> operationFactory.getInstance(null));
    }

    @Test
    void should_return_error_to_operation_not_implemented() {
        assertThrows(Exception.class, () -> operationFactory.getInstance("DERIVATIVE"));
    }
}