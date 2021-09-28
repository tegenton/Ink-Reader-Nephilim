package tegenton.card.parse.lexicon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PunctuationTest {
    public static Punctuation punctuation;

    @ParameterizedTest
    @ValueSource(strings = {".", ","})
    void validPunctuation(String s) {
        punctuation = Punctuation.fromString(s).orElse(null);
        assertNotNull(punctuation);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Whenever", "Lifelink"})
    void invalid(String s) {
        punctuation = Punctuation.fromString(s).orElse(null);
        assertNull(punctuation);
    }
}