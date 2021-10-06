package tegenton.card.game.concepts.symbols.mana;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.game.concepts.Color;

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
        symbol = PrimaryManaSymbol.fromString("W");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void primaryBlue() {
        colors.add(Color.blue);
        symbol = PrimaryManaSymbol.fromString("U");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void primaryBlack() {
        colors.add(Color.black);
        symbol = PrimaryManaSymbol.fromString("B");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void primaryRed() {
        colors.add(Color.red);
        symbol = PrimaryManaSymbol.fromString("R");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void primaryGreen() {
        colors.add(Color.green);
        symbol = PrimaryManaSymbol.fromString("G");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void primaryColorless() {
        symbol = PrimaryManaSymbol.fromString("C");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }
}
