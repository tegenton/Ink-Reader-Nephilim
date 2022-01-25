package tegenton.card.lexicon.game.source.target;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.WordTestTemplate;

import java.util.List;

public class TargetWordTest extends WordTestTemplate {
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
