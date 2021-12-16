package tegenton.card.parse.lexicon.source.target.player;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.WordTest;
import java.util.List;

public class PlayerWordTest extends WordTest {
    @Test
    void noun() {
        words = PlayerNoun.values();
        values = List.of("OPPONENT", "YOU");
    }

    @Test
    void verb() {
        words = PlayerVerb.values();
        values =
                List.of("ACTIVATE", "ADD", "ATTACH", "CAST", "CHANGE", "CHOOSE",
                        "CONTROL", "COULD", "COUNTER", "CREATE", "DESTROY",
                        "DISCARD", "DIVIDE", "DRAW", "EXCHANGE", "IGNORE",
                        "LOOK", "LOSE", "MAY", "OWN", "PAY", "PLAY", "PREVENT",
                        "PUT", "REGENERATE", "REMOVE", "RETURN", "SACRIFICE",
                        "SEARCH", "SHUFFLE", "SKIP", "SPEND", "TAKE");
    }
}
