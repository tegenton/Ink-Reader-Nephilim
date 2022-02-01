package tegenton.card.lexicon.game.source.target;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Word;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TargetWordTest {
    public static Word[] words;
    public static List<String> values;

    @AfterEach
    void compare() {
        assertEquals(words.length, values.size());
        for (int i = 0; i < words.length; i++) {
            assertEquals(values.get(i), words[i].toString());
        }
    }

    @Test
    void adjective() {
        words = TargetAdjective.values();
        values = List.of("ABLE");
    }

    @Test
    void modifier() {
        words = TargetModifier.values();
        values = List.of("\u2019s");
    }

    @Test
    void noun() {
        words = TargetNoun.values();
        values = List.of("THEM", "THEY", "WHO");
    }

    @Test
    void verb() {
        words = TargetVerb.values();
        values = List.of("ASSIGN", "GAIN", "LOSE");
    }

    @Test
    void auxiliaryVerb() {
        words = TargetAuxiliaryVerb.values();
        values = List.of("CAN", "WOULD");
    }
}
