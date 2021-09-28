package tegenton.card.game.concepts.symbols.tap;


import tegenton.card.game.concepts.symbols.Symbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UntapSymbolTest {
    public static Symbol symbol;

    @Test
    void untap() {
        symbol = UntapSymbol.fromString("Q").orElse(null);
        assertNotNull(symbol);
    }

    @Test
    void isInvalid() {
        symbol = UntapSymbol.fromString("{Q}").orElse(null);
        assertNull(symbol);
    }
}
