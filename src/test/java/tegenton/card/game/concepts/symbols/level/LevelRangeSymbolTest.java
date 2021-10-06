package tegenton.card.game.concepts.symbols.level;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class LevelRangeSymbolTest {
    public static LevelRangeSymbol symbol;

    @Test
    void isValid() {
        symbol = LevelRangeSymbol.fromString("LEVEL 5-8");
        assertNotNull(symbol);
    }

    @Test
    void isInvalid() {
        symbol = LevelRangeSymbol.fromString("LEVEL 5+");
        assertNull(symbol);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void min(int level) {
        symbol = LevelRangeSymbol.fromString("LEVEL " + level + "-10");
        assertNotNull(symbol);
        assertEquals(level, symbol.getMin());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void max(int level) {
        symbol = LevelRangeSymbol.fromString("LEVEL 0-" + level);
        assertNotNull(symbol);
        assertEquals(level, symbol.getMax());
    }
}
