import com.ntd.operation.OperationTypeEnum;
import com.ntd.operationservice.OperationFactoryImpl;
import com.ntd.operationservice.OperationService;
import com.ntd.operationservice.strategy.AdditionOperationService;
import com.ntd.operationservice.strategy.DivisionOperationService;
import com.ntd.operationservice.strategy.MultiplyOperationService;
import com.ntd.operationservice.strategy.RandomStringOperationService;
import com.ntd.operationservice.strategy.SquareRootOperationService;
import com.ntd.operationservice.strategy.SubtractionOperationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OperationFactoryImplTest {
    @Mock
    private AdditionOperationService additionOperationService;
    @Mock
    private DivisionOperationService divisionOperationService;
    @Mock
    private MultiplyOperationService multiplyOperationService;
    @Mock
    private RandomStringOperationService randomStringOperationService;
    @Mock
    private SquareRootOperationService squareRootOperationService;
    @Mock
    private SubtractionOperationService subtractionOperationService;

    private OperationFactoryImpl operationFactory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        operationFactory = new OperationFactoryImpl(additionOperationService, divisionOperationService, multiplyOperationService, randomStringOperationService, squareRootOperationService, subtractionOperationService);
    }

    @Test
    void should_return_addition_operation() {
        OperationService result = operationFactory.getInstance(OperationTypeEnum.ADDITION.name());

        assertTrue(result instanceof AdditionOperationService);
    }

    @Test
    void should_return_subtraction_operation() {
        OperationService result = operationFactory.getInstance(OperationTypeEnum.SUBTRACTION.name());

        assertTrue(result instanceof SubtractionOperationService);
    }

    @Test
    void should_return_multiply_operation() {
        OperationService result = operationFactory.getInstance(OperationTypeEnum.MULTIPLY.name());

        assertTrue(result instanceof MultiplyOperationService);
    }

    @Test
    void should_return_division_operation() {
        OperationService result = operationFactory.getInstance(OperationTypeEnum.DIVISION.name());

        assertTrue(result instanceof DivisionOperationService);
    }

    @Test
    void should_return_square_root_operation() {
        OperationService result = operationFactory.getInstance(OperationTypeEnum.SQUARE_ROOT.name());

        assertTrue(result instanceof SquareRootOperationService);
    }

    @Test
    void should_return_random_string_operation() {
        OperationService result = operationFactory.getInstance(OperationTypeEnum.RANDOM_STRING.name());

        assertTrue(result instanceof RandomStringOperationService);
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