package tegenton.card.game.concepts.symbols.tap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TapSymbolTest {
    public static TapSymbol symbol;

    @ParameterizedTest
    @ValueSource(strings = {"{T}", "{Q}"})
    void isValid(String s) {
        symbol = TapSymbol.fromString(s);
        assertNotNull(symbol);
    }

    @ParameterizedTest
    @ValueSource(strings = {"T", "Q"})
    void isInvalid(String s) {
        symbol = TapSymbol.fromString(s);
        assertNull(symbol);
    }

    @Test
    void tap() {
        symbol = TapSymbol.fromString("{T}");
        assertNotNull(symbol);
        assertEquals(TapTapSymbol.class, symbol.getClass());
    }

    @Test
    void untap() {
        symbol = TapSymbol.fromString("{Q}");
        assertNotNull(symbol);
        assertEquals(UntapSymbol.class, symbol.getClass());
    }
}
