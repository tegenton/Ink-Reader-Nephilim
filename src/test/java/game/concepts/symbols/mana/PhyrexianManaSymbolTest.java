package game.concepts.symbols.mana;

import game.concepts.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PhyrexianManaSymbolTest {
    public static EnumSet<Color> colors;
    public static PhyrexianManaSymbol symbol;

    @BeforeEach
    void setup() {
        colors = EnumSet.noneOf(Color.class);
    }

    @Test
    void primaryWhite() {
        colors.add(Color.white);
        symbol = (PhyrexianManaSymbol) PhyrexianManaSymbol.fromString("W/P").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void primaryBlue() {
        colors.add(Color.blue);
        symbol = (PhyrexianManaSymbol) PhyrexianManaSymbol.fromString("U/P").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void primaryBlack() {
        colors.add(Color.black);
        symbol = (PhyrexianManaSymbol) PhyrexianManaSymbol.fromString("B/P").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void primaryRed() {
        colors.add(Color.red);
        symbol = (PhyrexianManaSymbol) PhyrexianManaSymbol.fromString("R/P").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void primaryGreen() {
        colors.add(Color.green);
        symbol = (PhyrexianManaSymbol) PhyrexianManaSymbol.fromString("G/P").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }
}
