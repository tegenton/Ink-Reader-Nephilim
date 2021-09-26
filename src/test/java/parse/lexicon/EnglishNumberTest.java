package parse.lexicon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EnglishNumberTest {
    private static EnglishNumber num;

    @ParameterizedTest
    @ValueSource(strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"})
    void validNumbers(String s) {
        num = EnglishNumber.fromString(s).orElse(null);
        assertNotNull(num);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "X", "{3}"})
    void invalid(String s) {
        num = EnglishNumber.fromString(s).orElse(null);
        assertNull(num);
    }
}