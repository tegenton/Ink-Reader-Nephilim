package tegenton.card.parse.token.lexicon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class KeywordActionTest {
    public static KeywordAction keywordAction;

    @ParameterizedTest
    @ValueSource(strings = {"scry", "fateseal"})
    void validNumbers(String s) {
        keywordAction = KeywordAction.fromString(s).orElse(null);
        assertNotNull(keywordAction);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Whenever", "Lifelink"})
    void invalid(String s) {
        keywordAction = KeywordAction.fromString(s).orElse(null);
        assertNull(keywordAction);
    }
}