package tegenton.card.parse.lexicon.game.source;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.WordTest;

import java.util.List;

public class SourceWordTest extends WordTest {
    @Test
    void noun() {
        words = SourceNoun.values();
        values = List.of("SOURCE");
    }

    @Test
    void verb() {
        words = SourceVerb.values();
        values = List.of("DEAL", "DO", "PRODUCE");
    }
}