package tegenton.card.game.concepts.symbols;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VariableSymbolTest {
    public static VariableSymbol symbol;

    @Test
    void variable() {
        symbol = VariableSymbol.fromString("X");
        assertNotNull(symbol);
    }

    @Test
    void isInvalid() {
        symbol = VariableSymbol.fromString("{X}");
        assertNull(symbol);
    }

}
