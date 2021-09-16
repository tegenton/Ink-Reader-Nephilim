package game.concepts.symbols.loyalty;

import game.concepts.symbols.Symbol;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LoyaltySymbolTest {
    public static Symbol symbol;

    @ParameterizedTest
    @ValueSource(strings = {"[+1]", "+1", "0", "-1", "-X"})
    void isValid(String s) {
        symbol = LoyaltySymbol.fromString(s).orElse(null);
        assertNotNull(symbol);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "+0", "-0", "X"})
    void isInvalid(String s) {
        symbol = LoyaltySymbol.fromString(s).orElse(null);
        assertNull(symbol);
    }
}
