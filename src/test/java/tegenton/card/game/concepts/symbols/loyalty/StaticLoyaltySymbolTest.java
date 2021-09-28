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
        symbol = (StaticLoyaltySymbol) StaticLoyaltySymbol.fromString(s).orElse(null);
        assertNotNull(symbol);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-X"})
    void isInvalid(String s) {
        symbol = (StaticLoyaltySymbol) StaticLoyaltySymbol.fromString(s).orElse(null);
        assertNull(symbol);
    }

    @Test
    void plusOne() {
        symbol = (StaticLoyaltySymbol) StaticLoyaltySymbol.fromString("+1").orElse(null);
        assertNotNull(symbol);
        assertEquals(1, symbol.getValue());
    }

    @Test
    void zero() {
        symbol = (StaticLoyaltySymbol) StaticLoyaltySymbol.fromString("0").orElse(null);
        assertNotNull(symbol);
        assertEquals(0, symbol.getValue());
    }

    @Test
    void minusOne() {
        symbol = (StaticLoyaltySymbol) StaticLoyaltySymbol.fromString("-1").orElse(null);
        assertNotNull(symbol);
        assertEquals(-1, symbol.getValue());
    }
}
