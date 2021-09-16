package game.concepts.symbols;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VariableSymbolTest {
    public static Symbol symbol;

    @Test
    void variable() {
        symbol = VariableSymbol.fromString("X").orElse(null);
        assertNotNull(symbol);
    }

    @Test
    void isInvalid() {
        symbol = VariableSymbol.fromString("{X}").orElse(null);
        assertNull(symbol);
    }

}
