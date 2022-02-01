package tegenton.card.lexicon.game.source.target.player;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Word;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerWordTest {
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
    void adverb() {
        words = PlayerAdverb.values();
        values = List.of("CONTINUOUSLY");
    }

    @Test
    void adjective() {
        words = PlayerAdjective.values();
        values = List.of("ACTIVE", "DEFENDING");
    }

    @Test
    void attribute() {
        words = PlayerAttribute.values();
        values = List.of("MAXIMUM", "SIZE", "TOTAL");
    }

    @Test
    void noun() {
        words = PlayerNoun.values();
        values = List.of("OPPONENT", "YOU");
    }

    @Test
    void verb() {
        words = PlayerVerb.values();
        values = List.of("ACTIVATE", "ADD", "ATTACH", "BEGIN", "CAST", "CHANGE",
                "CHOOSE", "CONTROL", "COULD", "COUNTER", "CREATE", "DECLARE",
                "DESTROY", "DISCARD", "DIVIDE", "DRAW", "EXCHANGE", "FLIP",
                "IGNORE", "LOOK", "MAY", "OWN", "PAY", "PLAY", "PREVENT", "PUT",
                "REGENERATE", "REMOVE", "REPLACE", "RETURN", "SACRIFICE",
                "SEARCH", "SHUFFLE", "SKIP", "SPEND", "TAKE");
    }
}
