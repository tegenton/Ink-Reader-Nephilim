package tegenton.card.parse.lexicon.game.source.target;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.WordTest;

import java.util.List;

public class TargetWordTest extends WordTest {
    @Test
    void adjective() {
        words = TargetAdjective.values();
        values = List.of("ABLE");
    }

    @Test
    void noun() {
        words = TargetNoun.values();
        values = List.of("THEM", "THEY", "WHO");
    }

    @Test
    void verb() {
        words = TargetVerb.values();
        values = List.of("ASSIGN", "GAIN", "LOSE");
    }

    @Test
    void auxiliaryVerb() {
        words = TargetAuxiliaryVerb.values();
        values = List.of("CAN", "WOULD");
    }
}
