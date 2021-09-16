package game.concepts.symbols.chapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleChapterSymbolTest {
    public static MultipleChapterSymbol symbol;

    @ParameterizedTest
    @ValueSource(strings = {"I,II", "II,III", "I,II,III"})
    void isValid(String s) {
        symbol = (MultipleChapterSymbol) MultipleChapterSymbol.fromString(s).orElse(null);
        assertNotNull(symbol);
    }

    @ParameterizedTest
    @ValueSource(strings = {"I", "II", "III", "IV"})
    void isInvalid(String s) {
        symbol = (MultipleChapterSymbol) MultipleChapterSymbol.fromString(s).orElse(null);
        assertNull(symbol);
    }

    @Test
    void oneTwo() {
        symbol = (MultipleChapterSymbol) MultipleChapterSymbol.fromString("I,II").orElse(null);
        assertNotNull(symbol);
        assertArrayEquals(new int[]{1, 2}, symbol.getChapters());
    }

    @Test
    void twoThree() {
        symbol = (MultipleChapterSymbol) MultipleChapterSymbol.fromString("II,III").orElse(null);
        assertNotNull(symbol);
        assertArrayEquals(new int[]{2, 3}, symbol.getChapters());
    }

    @Test
    void oneTwoThree() {
        symbol = (MultipleChapterSymbol) MultipleChapterSymbol.fromString("I,II,III").orElse(null);
        assertNotNull(symbol);
        assertArrayEquals(new int[]{1, 2, 3}, symbol.getChapters());
    }
}
