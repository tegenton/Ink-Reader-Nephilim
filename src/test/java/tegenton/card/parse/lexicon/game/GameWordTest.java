package tegenton.card.parse.lexicon.game;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.WordTest;
import java.util.List;

public class GameWordTest extends WordTest {
    @Test
    void zone() {
        words = Zone.values();
        values = List.of("ANTE", "BATTLEFIELD", "EXILE", "GRAVEYARD", "HAND",
                         "LIBRARY");
    }
}
