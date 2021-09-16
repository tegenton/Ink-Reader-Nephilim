package game.concepts.symbols.level;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class LevelMinSymbolTest {
    public static LevelMinSymbol symbol;

    @Test
    void isValid() {
        symbol = (LevelMinSymbol) LevelMinSymbol.fromString("LEVEL 5+").orElse(null);
        assertNotNull(symbol);
    }

    @Test
    void isInvalid() {
        symbol = (LevelMinSymbol) LevelMinSymbol.fromString("LEVEL 5-8").orElse(null);
        assertNull(symbol);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void min(int level) {
        symbol = (LevelMinSymbol) LevelMinSymbol.fromString("LEVEL " + level + "+").orElse(null);
        assertNotNull(symbol);
        assertEquals(level, symbol.getMin());
    }
}
