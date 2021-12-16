package tegenton.card.parse.lexicon.game.source.target;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.WordTest;
import tegenton.card.parse.lexicon.game.source.target.TargetNoun;
import tegenton.card.parse.lexicon.game.source.target.TargetVerb;
import java.util.List;

public class TargetWordTest extends WordTest {
    @Test
    void noun() {
        words = TargetNoun.values();
        values = List.of("THEY");
    }

    @Test
    void verb() {
        words = TargetVerb.values();
        values = List.of("GAIN");
    }
}
