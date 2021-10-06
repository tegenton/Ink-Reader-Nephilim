package tegenton.card.game.concepts.symbols.chapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleChapterSymbolTest {
    public static MultipleChapterSymbol symbol;

    @ParameterizedTest
    @ValueSource(strings = {"I,II", "II,III", "I,II,III"})
    void isValid(String s) {
        symbol = MultipleChapterSymbol.fromString(s);
        assertNotNull(symbol);
    }

    @ParameterizedTest
    @ValueSource(strings = {"I", "II", "III", "IV"})
    void isInvalid(String s) {
        symbol = MultipleChapterSymbol.fromString(s);
        assertNull(symbol);
    }

    @Test
    void oneTwo() {
        symbol = MultipleChapterSymbol.fromString("I,II");
        assertNotNull(symbol);
        assertArrayEquals(new int[]{1, 2}, symbol.getChapters());
    }

    @Test
    void twoThree() {
        symbol = MultipleChapterSymbol.fromString("II,III");
        assertNotNull(symbol);
        assertArrayEquals(new int[]{2, 3}, symbol.getChapters());
    }

    @Test
    void oneTwoThree() {
        symbol = MultipleChapterSymbol.fromString("I,II,III");
        assertNotNull(symbol);
        assertArrayEquals(new int[]{1, 2, 3}, symbol.getChapters());
    }
}
