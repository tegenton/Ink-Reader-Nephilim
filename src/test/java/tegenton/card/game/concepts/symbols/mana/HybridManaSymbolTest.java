package tegenton.card.game.concepts.symbols.mana;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.game.concepts.Color;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HybridManaSymbolTest {
    public static EnumSet<Color> colors;
    public static HybridManaSymbol symbol;

    /*
        the hybrid symbols {W/U}, {W/B}, {U/B},
                {U/R}, {B/R}, {B/G}, {R/G}, {R/W}, {G/W}, and {G/U}
         */
    @BeforeEach
    void setup() {
        colors = EnumSet.noneOf(Color.class);
    }

    @Test
    void whiteBlue() {
        colors = EnumSet.of(Color.white, Color.blue);
        symbol = HybridManaSymbol.fromString("W/U");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void whiteBlack() {
        colors = EnumSet.of(Color.white, Color.black);
        symbol = HybridManaSymbol.fromString("W/B");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void blueBlack() {
        colors = EnumSet.of(Color.blue, Color.black);
        symbol = HybridManaSymbol.fromString("U/B");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void redBlue() {
        colors = EnumSet.of(Color.red, Color.blue);
        symbol = HybridManaSymbol.fromString("R/U");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void blackRed() {
        colors = EnumSet.of(Color.black, Color.red);
        symbol = HybridManaSymbol.fromString("B/R");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void blackGreen() {
        colors = EnumSet.of(Color.black, Color.green);
        symbol = HybridManaSymbol.fromString("B/G");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void redGreen() {
        colors = EnumSet.of(Color.red, Color.green);
        symbol = HybridManaSymbol.fromString("R/G");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void redWhite() {
        colors = EnumSet.of(Color.red, Color.white);
        symbol = HybridManaSymbol.fromString("R/W");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void greenWhite() {
        colors = EnumSet.of(Color.green, Color.white);
        symbol = HybridManaSymbol.fromString("G/W");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void greenBlue() {
        colors = EnumSet.of(Color.green, Color.blue);
        symbol = HybridManaSymbol.fromString("G/U");
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }
}
