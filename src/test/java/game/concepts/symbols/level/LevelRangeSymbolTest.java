package game.concepts.symbols.level;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class LevelRangeSymbolTest {
    public static LevelRangeSymbol symbol;

    @Test
    void isValid() {
        symbol = (LevelRangeSymbol) LevelRangeSymbol.fromString("LEVEL 5-8").orElse(null);
        assertNotNull(symbol);
    }

    @Test
    void isInvalid() {
        symbol = (LevelRangeSymbol) LevelRangeSymbol.fromString("LEVEL 5+").orElse(null);
        assertNull(symbol);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void min(int level) {
        symbol = (LevelRangeSymbol) LevelRangeSymbol.fromString("LEVEL " + level + "-10").orElse(null);
        assertNotNull(symbol);
        assertEquals(level, symbol.getMin());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void max(int level) {
        symbol = (LevelRangeSymbol) LevelRangeSymbol.fromString("LEVEL 0-" + level).orElse(null);
        assertNotNull(symbol);
        assertEquals(level, symbol.getMax());
    }
}
