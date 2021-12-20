package tegenton.card.parse.lexicon.game.turn;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.WordTest;

import java.util.List;

public class TimeQuantifierWordTest extends WordTest {
    @Test
    void duration() {
        words = Duration.values();
        values = List.of("SINCE", "UNTIL");
    }

    @Test
    void chronology() {
        words = Chronology.values();
        values = List.of("AFTER", "BEFORE", "DURING");
    }
}
