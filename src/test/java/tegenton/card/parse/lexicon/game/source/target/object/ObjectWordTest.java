package tegenton.card.parse.lexicon.game.source.target.object;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.WordTest;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectAttribute;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectNoun;
import tegenton.card.parse.lexicon.game.source.target.object.ObjectVerb;
import java.util.List;

public class ObjectWordTest extends WordTest {
    @Test
    void attribute() {
        words = ObjectAttribute.values();
        values = List.of("POWER", "TOUGHNESS", "VALUE");
    }

    @Test
    void noun() {
        words = ObjectNoun.values();
        values = List.of("CARD", "COPY", "IT", "PERMANENT", "SPELL", "TOKEN");
    }

    @Test
    void verb() {
        words = ObjectVerb.values();
        values = List.of("ATTACK", "BECOME", "BLOCK", "COST", "DIE", "ENTER",
                         "GET", "HAVE", "IS", "LEAVE", "TAP");
    }
}
