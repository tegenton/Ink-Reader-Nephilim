package tegenton.card.parse.token;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class KeywordActionTokenTest {
    public static KeywordActionToken keywordActionToken;

    @ParameterizedTest
    @ValueSource(strings = {
            "activate",
            "attach",
            "cast",
            "counter",
            "create",
            "destroy",
            "discard",
            "double",
            "exchange",
            "exile",
            "fight",
            "mill",
            "play",
            "regenerate",
            "reveal",
            "sacrifice",
            "scry",
            "search",
            "tap",
            "untap",
            "fateseal",
            "clash",
            "planeswalk",
            "set in motion",
            "abandon",
            "proliferate",
            "transform",
            "detain",
            "populate",
            "monstrosity",
            "vote",
            "bolster",
            "manifest",
            "support",
            "investigate",
            "meld",
            "goad",
            "exert",
            "explore",
            "assemble",
            "surveil",
            "adapt",
            "amass",
            "learn",
            "venture into the dungeon"})
    void validActions(String s) {
        keywordActionToken = KeywordActionToken.fromString(s);
        assertNotNull(keywordActionToken);
        Assertions.assertEquals(s, keywordActionToken.getWord().getWord());
    }

    @Test
    void invalid() {
        keywordActionToken = KeywordActionToken.fromString("when");
        assertNull(keywordActionToken);
    }
}
