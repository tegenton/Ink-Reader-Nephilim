package tegenton.card.game.concepts.symbols.tap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TapTapSymbolTest {
    public static TapTapSymbol symbol;

    @Test
    void tap() {
        symbol = TapTapSymbol.fromString("T");
        assertNotNull(symbol);
    }

    @Test
    void isInvalid() {
        symbol = TapTapSymbol.fromString("{T}");
        assertNull(symbol);
    }
}
