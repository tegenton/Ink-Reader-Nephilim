package game.concepts.symbols.mana;

import game.concepts.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PrimaryManaSymbolTest {
    public static EnumSet<Color> colors;
    public static PrimaryManaSymbol symbol;

    @BeforeEach
    void setup() {
        colors = EnumSet.noneOf(Color.class);
    }

    @Test
    void primaryWhite() {
        colors.add(Color.white);
        symbol = (PrimaryManaSymbol) PrimaryManaSymbol.fromString("W").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void primaryBlue() {
        colors.add(Color.blue);
        symbol = (PrimaryManaSymbol) PrimaryManaSymbol.fromString("U").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void primaryBlack() {
        colors.add(Color.black);
        symbol = (PrimaryManaSymbol) PrimaryManaSymbol.fromString("B").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void primaryRed() {
        colors.add(Color.red);
        symbol = (PrimaryManaSymbol) PrimaryManaSymbol.fromString("R").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void primaryGreen() {
        colors.add(Color.green);
        symbol = (PrimaryManaSymbol) PrimaryManaSymbol.fromString("G").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void primaryColorless() {
        symbol = (PrimaryManaSymbol) PrimaryManaSymbol.fromString("C").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }
}
