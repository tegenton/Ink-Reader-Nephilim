package tegenton.card.game.concepts.symbols.chapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class SingleChapterSymbolTest {
    public static SingleChapterSymbol symbol;

    @ParameterizedTest
    @ValueSource(strings = {"I", "II", "III", "IV"})
    void isValid(String s) {
        symbol = SingleChapterSymbol.fromString(s);
        assertNotNull(symbol);
    }

    @ParameterizedTest
    @ValueSource(strings = {"I,II", "II,III", "I,II,III"})
    void isInvalid(String s) {
        symbol = SingleChapterSymbol.fromString(s);
        assertNull(symbol);
    }

    @Test
    void one() {
        symbol = SingleChapterSymbol.fromString("I");
        assertNotNull(symbol);
        assertEquals(1, symbol.getChapter());
    }

    @Test
    void two() {
        symbol = SingleChapterSymbol.fromString("II");
        assertNotNull(symbol);
        assertEquals(2, symbol.getChapter());
    }

    @Test
    void three() {
        symbol = SingleChapterSymbol.fromString("III");
        assertNotNull(symbol);
        assertEquals(3, symbol.getChapter());
    }

    @Test
    void four() {
        symbol = SingleChapterSymbol.fromString("IV");
        assertNotNull(symbol);
        assertEquals(4, symbol.getChapter());
    }

    @Test
    void five() {
        symbol = SingleChapterSymbol.fromString("V");
        assertNotNull(symbol);
        assertEquals(5, symbol.getChapter());
    }
}
