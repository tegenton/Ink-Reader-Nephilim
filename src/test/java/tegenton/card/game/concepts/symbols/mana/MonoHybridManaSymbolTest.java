package tegenton.card.game.concepts.symbols.mana;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.game.concepts.Color;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MonoHybridManaSymbolTest {
    public static EnumSet<Color> colors;
    public static MonoHybridManaSymbol symbol;

    @BeforeEach
    void setup() {
        colors = EnumSet.noneOf(Color.class);
    }

    @Test
    void primaryWhite() {
        colors.add(Color.white);
        symbol = MonoHybridManaSymbol.fromString("2/W");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(2, symbol.getManaValue());
    }

    @Test
    void primaryBlue() {
        colors.add(Color.blue);
        symbol = MonoHybridManaSymbol.fromString("2/U");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(2, symbol.getManaValue());
    }

    @Test
    void primaryBlack() {
        colors.add(Color.black);
        symbol = MonoHybridManaSymbol.fromString("2/B");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(2, symbol.getManaValue());
    }

    @Test
    void primaryRed() {
        colors.add(Color.red);
        symbol = MonoHybridManaSymbol.fromString("2/R");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(2, symbol.getManaValue());
    }

    @Test
    void primaryGreen() {
        colors.add(Color.green);
        symbol = MonoHybridManaSymbol.fromString("2/G");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(2, symbol.getManaValue());
    }
}
