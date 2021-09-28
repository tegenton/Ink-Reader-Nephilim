package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.Color;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NumericManaSymbolTest {
    public static NumericManaSymbol symbol;

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    void number(int value) {
        symbol = (NumericManaSymbol) NumericManaSymbol.fromString(Integer.toString(value)).orElse(null);
        assertNotNull(symbol);
        assertEquals(value, symbol.getManaValue());
        assertEquals(EnumSet.noneOf(Color.class), symbol.getType());
    }
}
