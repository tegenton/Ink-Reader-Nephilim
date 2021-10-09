package tegenton.card.parse.token.lexicon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class KeywordActionTest {
    public static KeywordAction keywordAction;

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
        keywordAction = KeywordAction.fromString(s);
        assertNotNull(keywordAction);
        assertEquals(s, keywordAction.getWord());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Whenever", "Lifelink"})
    void invalid(String s) {
        keywordAction = KeywordAction.fromString(s);
        assertNull(keywordAction);
    }
}