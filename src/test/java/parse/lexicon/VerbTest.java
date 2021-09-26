package parse.lexicon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VerbTest {
    public static Verb num;

    @ParameterizedTest
    @ValueSource(strings = {"draw", "create"})
    void validNumbers(String s) {
        num = Verb.fromString(s).orElse(null);
        assertNotNull(num);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Whenever", "Lifelink"})
    void invalid(String s) {
        num = Verb.fromString(s).orElse(null);
        assertNull(num);
    }
}