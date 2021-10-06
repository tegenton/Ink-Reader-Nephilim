package tegenton.card.parse.token.lexicon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberTest {
    private static Number num;

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"})
    void validNumbers(String s) {
        num = Number.fromString(s).orElse(null);
        assertNotNull(num);
        assertEquals(s, num.getWord());
    }

    @Test
    void value() {
        for (int i = 0; i < 20; i++) {
            num = Number.fromString(Integer.toString(i)).orElse(null);
            assertNotNull(num);
            assertEquals(i, num.getVal());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"One", "X", "{3}"})
    void invalid(String s) {
        num = Number.fromString(s).orElse(null);
        assertNull(num);
    }
}