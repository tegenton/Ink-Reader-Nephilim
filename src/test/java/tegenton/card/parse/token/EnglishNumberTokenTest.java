package tegenton.card.parse.token;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tegenton.card.parse.token.lexicon.EnglishNumber;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EnglishNumberTokenTest {
    public static EnglishNumberToken englishNumberToken;

    @ParameterizedTest
    @ValueSource(strings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"})
    void validNumbers(String s) {
        englishNumberToken = EnglishNumberToken.fromString(s);
        assertNotNull(englishNumberToken);
        Assertions.assertEquals(EnglishNumber.fromString(s), englishNumberToken.getWord());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Whenever", "5", "X"})
    void invalid(String s) {
        englishNumberToken = EnglishNumberToken.fromString(s);
        assertNull(englishNumberToken);
    }
}
