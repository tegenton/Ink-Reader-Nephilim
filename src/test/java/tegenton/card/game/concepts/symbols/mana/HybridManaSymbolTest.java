package tegenton.card.game.concepts.symbols.mana;

import tegenton.card.game.concepts.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        symbol = (HybridManaSymbol) HybridManaSymbol.fromString("W/U").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void whiteBlack() {
        colors = EnumSet.of(Color.white, Color.black);
        symbol = (HybridManaSymbol) HybridManaSymbol.fromString("W/B").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void blueBlack() {
        colors = EnumSet.of(Color.blue, Color.black);
        symbol = (HybridManaSymbol) HybridManaSymbol.fromString("U/B").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void redBlue() {
        colors = EnumSet.of(Color.red, Color.blue);
        symbol = (HybridManaSymbol) HybridManaSymbol.fromString("R/U").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void blackRed() {
        colors = EnumSet.of(Color.black, Color.red);
        symbol = (HybridManaSymbol) HybridManaSymbol.fromString("B/R").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void blackGreen() {
        colors = EnumSet.of(Color.black, Color.green);
        symbol = (HybridManaSymbol) HybridManaSymbol.fromString("B/G").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void redGreen() {
        colors = EnumSet.of(Color.red, Color.green);
        symbol = (HybridManaSymbol) HybridManaSymbol.fromString("R/G").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void redWhite() {
        colors = EnumSet.of(Color.red, Color.white);
        symbol = (HybridManaSymbol) HybridManaSymbol.fromString("R/W").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void greenWhite() {
        colors = EnumSet.of(Color.green, Color.white);
        symbol = (HybridManaSymbol) HybridManaSymbol.fromString("G/W").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }

    @Test
    void greenBlue() {
        colors = EnumSet.of(Color.green, Color.blue);
        symbol = (HybridManaSymbol) HybridManaSymbol.fromString("G/U").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(1, symbol.getManaValue());
    }
}
