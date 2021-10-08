package tegenton.card.parse.token;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tegenton.card.parse.token.lexicon.KeywordAction;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class KeywordActionTokenTest {
    public static KeywordActionToken keywordActionToken;

    @Test
    void scry() {
        keywordActionToken = KeywordActionToken.fromString("scry");
        assertNotNull(keywordActionToken);
        Assertions.assertEquals(KeywordAction.scry, keywordActionToken.getWord());
    }

    @Test
    void invalid() {
        keywordActionToken = KeywordActionToken.fromString("when");
        assertNull(keywordActionToken);
    }
}