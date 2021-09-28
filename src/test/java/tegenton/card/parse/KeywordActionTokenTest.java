package tegenton.card.parse;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.KeywordAction;

import static org.junit.jupiter.api.Assertions.*;

public class KeywordActionTokenTest {
    public static KeywordActionToken keywordActionToken;

    @Test
    void scry() {
        keywordActionToken = (KeywordActionToken) KeywordActionToken.fromString("scry").orElse(null);
        assertNotNull(keywordActionToken);
        assertEquals(KeywordAction.scry, keywordActionToken.getWord());
    }

    @Test
    void invalid() {
        keywordActionToken = (KeywordActionToken) KeywordActionToken.fromString("when").orElse(null);
        assertNull(keywordActionToken);
    }
}
