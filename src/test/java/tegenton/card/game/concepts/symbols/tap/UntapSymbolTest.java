package tegenton.card.game.concepts.symbols.tap;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UntapSymbolTest {
    public static UntapSymbol symbol;

    @Test
    void untap() {
        symbol = UntapSymbol.fromString("Q");
        assertNotNull(symbol);
    }

    @Test
    void isInvalid() {
        symbol = UntapSymbol.fromString("{Q}");
        assertNull(symbol);
    }
}
