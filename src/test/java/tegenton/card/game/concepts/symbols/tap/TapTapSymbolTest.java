package tegenton.card.game.concepts.symbols.tap;

import tegenton.card.game.concepts.symbols.Symbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TapTapSymbolTest {
    public static Symbol symbol;

    @Test
    void tap() {
        symbol = TapTapSymbol.fromString("T").orElse(null);
        assertNotNull(symbol);
    }

    @Test
    void isInvalid() {
        symbol = TapTapSymbol.fromString("{T}").orElse(null);
        assertNull(symbol);
    }
}
