package tegenton.card.parse.dfa.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberStateTest {
    public static int expected;
    public static NumberState numberState;

    @BeforeEach
    void setup() {
        expected = 0;
        numberState = NumberState.state('0');
    }

    @AfterEach
    void produce() {
        assertTrue(numberState.produce('\0').isPresent());
        assertEquals(expected, numberState.produce('\0').get().getVal());
    }

    @Test
    void state() {
        expected = 1;
        numberState = NumberState.state('1');
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15})
    void transition(int i) {
        expected = i;
        String.valueOf(i).chars().mapToObj(c -> (char) c).forEach(numberState::transition);
    }

    @Test
    void transitionSpace() {
        assertTrue(numberState.transition(' ') instanceof SpaceState);
    }
}
