package tegenton.card.game.concepts.symbols.loyalty;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class VariableLoyaltySymbolTest {
    public static VariableLoyaltySymbol result;

    @Test
    void minusX() {
        result = VariableLoyaltySymbol.fromString("-X");
        assertNotNull(result);
    }

    @Test
    void zeroByDefault() {
        result = VariableLoyaltySymbol.fromString("-X");
        assertNotNull(result);
        assertEquals(0, result.getValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"+1", "0", "-1"})
    void isInvalid(String s) {
        result = VariableLoyaltySymbol.fromString(s);
        assertNull(result);
    }

}
