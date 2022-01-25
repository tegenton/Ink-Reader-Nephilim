package tegenton.card.lexicon.game.turn;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.WordTestTemplate;

import java.util.List;

public class TimeQuantifierWordTest extends WordTestTemplate {
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
}
