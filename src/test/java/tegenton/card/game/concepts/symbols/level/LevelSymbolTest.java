package tegenton.card.game.concepts.symbols.level;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LevelSymbolTest {
    public static LevelSymbol symbol;

    @Test
    void range() {
        symbol = LevelSymbol.fromString("LEVEL 1-2");
        assertNotNull(symbol);
        assertEquals(LevelRangeSymbol.class, symbol.getClass());
    }

    @Test
    void min() {
        symbol = LevelSymbol.fromString("LEVEL 3+");
        assertNotNull(symbol);
        assertEquals(LevelMinSymbol.class, symbol.getClass());
    }
}
