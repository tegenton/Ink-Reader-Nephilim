package tegenton.card.parse.token.lexicon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VerbTest {
    public static Verb verb;

    @ParameterizedTest
    @ValueSource(strings = {"draw", "create"})
    void validNumbers(String s) {
        verb = Verb.fromString(s).orElse(null);
        assertNotNull(verb);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Whenever", "Lifelink"})
    void invalid(String s) {
        verb = Verb.fromString(s).orElse(null);
        assertNull(verb);
    }
}