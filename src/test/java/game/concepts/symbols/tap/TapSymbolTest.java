package game.concepts.symbols.tap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TapSymbolTest {
    public static TapSymbol symbol;

    @ParameterizedTest
    @ValueSource(strings = {"{T}", "{Q}"})
    void isValid(String s) {
        symbol = (TapSymbol) TapSymbol.fromString(s).orElse(null);
        assertNotNull(symbol);
    }

    @ParameterizedTest
    @ValueSource(strings = {"T", "Q"})
    void isInvalid(String s) {
        symbol = (TapSymbol) TapSymbol.fromString(s).orElse(null);
        assertNull(symbol);
    }

    @Test
    void tap() {
        symbol = (TapSymbol) TapSymbol.fromString("{T}").orElse(null);
        assertNotNull(symbol);
        assertEquals(TapTapSymbol.class, symbol.getClass());
    }

    @Test
    void untap() {
        symbol = (TapSymbol) TapSymbol.fromString("{Q}").orElse(null);
        assertNotNull(symbol);
        assertEquals(UntapSymbol.class, symbol.getClass());
    }
}
