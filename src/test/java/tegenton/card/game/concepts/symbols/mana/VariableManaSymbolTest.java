package tegenton.card.game.concepts.symbols.mana;

import org.junit.jupiter.api.Test;
import tegenton.card.game.concepts.Color;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VariableManaSymbolTest {
    public static VariableManaSymbol symbol;

    @Test
    void valueZeroByDefault() {
        symbol = VariableManaSymbol.fromString("X");
        assertNotNull(symbol);
        assertEquals(0, symbol.getManaValue());
        assertEquals(EnumSet.noneOf(Color.class), symbol.getType());
    }
}
