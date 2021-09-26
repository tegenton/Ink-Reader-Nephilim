package parse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import parse.lexicon.EnglishNumber;

import static org.junit.jupiter.api.Assertions.*;

public class EnglishNumberTokenTest {
    public static EnglishNumberToken englishNumberToken;

    @ParameterizedTest
    @ValueSource(strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"})
    void validNumbers(String s) {
        englishNumberToken = (EnglishNumberToken) EnglishNumberToken.fromString(s).orElse(null);
        assertNotNull(englishNumberToken);
        assertEquals(EnglishNumber.fromString(s).orElse(null), englishNumberToken.getWord());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Whenever", "5", "X"})
    void invalid(String s) {
        englishNumberToken = (EnglishNumberToken) EnglishNumberToken.fromString(s).orElse(null);
        assertNull(englishNumberToken);
    }
}
