package tegenton.card.game.concepts.symbols.chapter;

import tegenton.card.game.concepts.symbols.Symbol;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ChapterSymbolTest {
    public static Symbol symbol;

    @ParameterizedTest
    @ValueSource(strings = {"I", "II", "III", "IV", "I,II", "II,III", "I,II,III"})
    void isValid(String s) {
        symbol = ChapterSymbol.fromString(s).orElse(null);
        assertNotNull(symbol);
    }

    @ParameterizedTest
    @ValueSource(strings = {"X", "1", "2", "3", "4", "1,2"})
    void isInvalid(String s) {
        symbol = ChapterSymbol.fromString(s).orElse(null);
        assertNull(symbol);
    }

    @ParameterizedTest
    @ValueSource(strings = {"I", "II", "III", "IV"})
    void single(String s) {
        symbol = ChapterSymbol.fromString(s).orElse(null);
        assertNotNull(symbol);
        assertEquals(SingleChapterSymbol.class, symbol.getClass());
    }

    @ParameterizedTest
    @ValueSource(strings = {"I,II", "II,III", "I,II,III"})
    void multiple(String s) {
        symbol = ChapterSymbol.fromString(s).orElse(null);
        assertNotNull(symbol);
        assertEquals(MultipleChapterSymbol.class, symbol.getClass());
    }
}
