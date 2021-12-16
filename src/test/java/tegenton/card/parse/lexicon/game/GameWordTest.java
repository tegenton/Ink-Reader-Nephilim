package tegenton.card.parse.lexicon.game;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.WordTest;
import java.util.List;

public class GameWordTest extends WordTest {
    @Test
    void keyword() {
        words = Keyword.values();
        values = List.of("BANDING", "DEFENDER", "ENCHANT", "FEAR", "FIRST",
                         "FLYING", "HASTE", "INDESTRUCTIBLE", "PROTECTION",
                         "REACH", "STRIKE", "TRAMPLE", "VIGILANCE", "WALK");
    }

    @Test
    void triggerWord() {
        words = TriggerWord.values();
        values = List.of("WHEN", "WHENEVER", "AT");
    }

    @Test
    void zone() {
        words = Zone.values();
        values = List.of("ANTE", "BATTLEFIELD", "EXILE", "GRAVEYARD", "HAND",
                         "LIBRARY");
    }
}
