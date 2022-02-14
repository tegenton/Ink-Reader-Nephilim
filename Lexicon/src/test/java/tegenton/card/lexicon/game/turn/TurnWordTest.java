package tegenton.card.lexicon.game.turn;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Word;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnWordTest {
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
    void duration() {
        words = Duration.values();
        values = List.of("SINCE", "UNTIL", "WHILE");
    }

    @Test
    void chronology() {
        words = Chronology.values();
        values = List.of("AFTER", "BEFORE", "DURING");
    }

    @Test
    void phase() {
        words = Phase.values();
        values = List.of("BEGINNING", "MAIN", "COMBAT");
    }

    @Test
    void step() {
        words = Step.values();
        values = List.of("UPKEEP", "END");
    }
}
