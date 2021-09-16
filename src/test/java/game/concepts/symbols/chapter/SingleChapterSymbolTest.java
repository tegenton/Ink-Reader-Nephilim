package game.concepts.symbols.chapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class SingleChapterSymbolTest {
    public static SingleChapterSymbol symbol;

    @ParameterizedTest
    @ValueSource(strings = {"I", "II", "III", "IV"})
    void isValid(String s) {
        symbol = (SingleChapterSymbol) SingleChapterSymbol.fromString(s).orElse(null);
        assertNotNull(symbol);
    }

    @ParameterizedTest
    @ValueSource(strings = {"I,II", "II,III", "I,II,III"})
    void isInvalid(String s) {
        symbol = (SingleChapterSymbol) SingleChapterSymbol.fromString(s).orElse(null);
        assertNull(symbol);
    }

    @Test
    void one() {
        symbol = (SingleChapterSymbol) SingleChapterSymbol.fromString("I").orElse(null);
        assertNotNull(symbol);
        assertEquals(1, symbol.getChapter());
    }

    @Test
    void two() {
        symbol = (SingleChapterSymbol) SingleChapterSymbol.fromString("II").orElse(null);
        assertNotNull(symbol);
        assertEquals(2, symbol.getChapter());
    }

    @Test
    void three() {
        symbol = (SingleChapterSymbol) SingleChapterSymbol.fromString("III").orElse(null);
        assertNotNull(symbol);
        assertEquals(3, symbol.getChapter());
    }

    @Test
    void four() {
        symbol = (SingleChapterSymbol) SingleChapterSymbol.fromString("IV").orElse(null);
        assertNotNull(symbol);
        assertEquals(4, symbol.getChapter());
    }

    @Test
    void five() {
        symbol = (SingleChapterSymbol) SingleChapterSymbol.fromString("V").orElse(null);
        assertNotNull(symbol);
        assertEquals(5, symbol.getChapter());
    }
}
