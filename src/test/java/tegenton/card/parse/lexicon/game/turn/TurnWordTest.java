package tegenton.card.parse.lexicon.game.turn;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.WordTestTemplate;

import java.util.List;

public class TurnWordTest extends WordTestTemplate {
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
