package game.concepts.symbols.mana;

import game.concepts.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        symbol = (MonoHybridManaSymbol) MonoHybridManaSymbol.fromString("2/W").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(2, symbol.getManaValue());
    }

    @Test
    void primaryBlue() {
        colors.add(Color.blue);
        symbol = (MonoHybridManaSymbol) MonoHybridManaSymbol.fromString("2/U").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(2, symbol.getManaValue());
    }

    @Test
    void primaryBlack() {
        colors.add(Color.black);
        symbol = (MonoHybridManaSymbol) MonoHybridManaSymbol.fromString("2/B").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(2, symbol.getManaValue());
    }

    @Test
    void primaryRed() {
        colors.add(Color.red);
        symbol = (MonoHybridManaSymbol) MonoHybridManaSymbol.fromString("2/R").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(2, symbol.getManaValue());
    }

    @Test
    void primaryGreen() {
        colors.add(Color.green);
        symbol = (MonoHybridManaSymbol) MonoHybridManaSymbol.fromString("2/G").orElse(null);
        assertNotNull(symbol);
        assertEquals(colors, symbol.getType());
        assertEquals(2, symbol.getManaValue());
    }
}
