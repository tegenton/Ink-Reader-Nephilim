package tegenton.card.game.concepts.symbols.level;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class LevelMinSymbolTest {
    public static LevelMinSymbol symbol;

    @Test
    void isValid() {
        symbol = LevelMinSymbol.fromString("LEVEL 5+");
        assertNotNull(symbol);
    }

    @Test
    void isInvalid() {
        symbol = LevelMinSymbol.fromString("LEVEL 5-8");
        assertNull(symbol);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void min(int level) {
        symbol = LevelMinSymbol.fromString("LEVEL " + level + "+");
        assertNotNull(symbol);
        assertEquals(level, symbol.getMin());
    }
}
