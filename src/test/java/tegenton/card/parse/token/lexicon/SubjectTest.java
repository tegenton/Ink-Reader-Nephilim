package tegenton.card.parse.token.lexicon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SubjectTest {
    public static Subject subject;

    @ParameterizedTest
    @ValueSource(strings = {"card", "cards"})
    void validNumbers(String s) {
        subject = Subject.fromString(s);
        assertNotNull(subject);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Whenever", "Lifelink"})
    void invalid(String s) {
        subject = Subject.fromString(s);
        assertNull(subject);
    }
}