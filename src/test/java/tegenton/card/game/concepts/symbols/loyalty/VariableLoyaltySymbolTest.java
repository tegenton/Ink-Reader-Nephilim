package tegenton.card.game.concepts.symbols.loyalty;

import tegenton.card.game.concepts.symbols.Symbol;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VariableLoyaltySymbolTest {
    public static Symbol result;

    @Test
    void minusX() {
        result = VariableLoyaltySymbol.fromString("-X").orElse(null);
        assertNotNull(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"+1", "0", "-1"})
    void isInvalid(String s) {
        result = VariableLoyaltySymbol.fromString(s).orElse(null);
        assertNull(result);
    }

}
