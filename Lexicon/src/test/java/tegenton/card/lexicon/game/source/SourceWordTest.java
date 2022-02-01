package tegenton.card.lexicon.game.source;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Word;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SourceWordTest {
    public static Word[] words;
    public static List<String> values;

    @AfterEach
    void compare() {
        assertEquals(values.size(), words.length);
        for (int i = 0; i < words.length; i++) {
            assertEquals(values.get(i), words[i].toString());
        }
    }

    @Test
    void noun() {
        words = SourceNoun.values();
        values = List.of("SOURCE");
    }

    @Test
    void verb() {
        words = SourceVerb.values();
        values = List.of("DEAL", "DO", "PRODUCE", "RESOLVE");
    }
}
