package tegenton.card.lexicon.game.source.target.object;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Word;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectWordTest {
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
        words = ObjectAdjective.values();
        values = List.of("TOP");
    }

    @Test
    void attribute() {
        words = ObjectAttribute.values();
        values = List.of("FACE", "LOYALTY", "NAME", "POWER", "TOUGHNESS",
                "VALUE");
    }

    @Test
    void noun() {
        words = ObjectNoun.values();
        values = List.of("CARD", "COPY", "IT", "PERMANENT", "SPELL", "TOKEN");
    }

    @Test
    void verb() {
        words = ObjectVerb.values();
        values = List.of("ATTACK", "BECOME", "BLOCK", "COST", "DIE", "ENTER",
                "GET", "HAVE", "IS", "LEAVE", "TAP");
    }
}
