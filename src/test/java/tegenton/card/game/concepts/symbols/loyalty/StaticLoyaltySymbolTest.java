package tegenton.card.game.concepts.symbols.loyalty;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class StaticLoyaltySymbolTest {
    public static StaticLoyaltySymbol symbol;

    @ParameterizedTest
    @ValueSource(strings = {"[+1]", "+1", "0", "-1"})
    void isValid(String s) {
        symbol = StaticLoyaltySymbol.fromString(s);
        assertNotNull(symbol);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-X"})
    void isInvalid(String s) {
        symbol = StaticLoyaltySymbol.fromString(s);
        assertNull(symbol);
    }

    @Test
    void plusOne() {
        symbol = StaticLoyaltySymbol.fromString("+1");
        assertNotNull(symbol);
        assertEquals(1, symbol.getValue());
    }

    @Test
    void zero() {
        symbol = StaticLoyaltySymbol.fromString("0");
        assertNotNull(symbol);
        assertEquals(0, symbol.getValue());
    }

    @Test
    void minusOne() {
        symbol = StaticLoyaltySymbol.fromString("-1");
        assertNotNull(symbol);
        assertEquals(-1, symbol.getValue());
    }
}
