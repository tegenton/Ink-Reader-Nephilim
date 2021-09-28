package tegenton.card.game.concepts.symbols.level;

import tegenton.card.game.concepts.symbols.Symbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LevelSymbolTest {
    public static Symbol symbol;

    @Test
    void range() {
        symbol = LevelSymbol.fromString("LEVEL 1-2").orElse(null);
        assertNotNull(symbol);
        assertEquals(LevelRangeSymbol.class, symbol.getClass());
    }

    @Test
    void min() {
        symbol = LevelSymbol.fromString("LEVEL 3+").orElse(null);
        assertNotNull(symbol);
        assertEquals(LevelMinSymbol.class, symbol.getClass());
    }
}
