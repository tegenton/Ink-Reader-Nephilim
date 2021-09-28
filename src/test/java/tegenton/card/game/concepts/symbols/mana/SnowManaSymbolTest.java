package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.Color;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SnowManaSymbolTest {
    public static SnowManaSymbol symbol;

    @Test
    void snow() {
        symbol = (SnowManaSymbol) SnowManaSymbol.fromString("S").orElse(null);
        assertNotNull(symbol);
        assertEquals(1, symbol.getManaValue());
        assertEquals(EnumSet.noneOf(Color.class), symbol.getType());
    }
}
