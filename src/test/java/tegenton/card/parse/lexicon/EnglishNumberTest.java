package tegenton.card.parse.lexicon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EnglishNumberTest {
    private static EnglishNumber num;

    @ParameterizedTest
    @ValueSource(strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"})
    void validNumbers(String s) {
        num = EnglishNumber.fromString(s).orElse(null);
        assertNotNull(num);
    }

    @Test
    void value() {
        assertEquals(1, EnglishNumber.one.getVal());
        assertEquals(2, EnglishNumber.two.getVal());
        assertEquals(3, EnglishNumber.three.getVal());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "X", "{3}"})
    void invalid(String s) {
        num = EnglishNumber.fromString(s).orElse(null);
        assertNull(num);
    }
}