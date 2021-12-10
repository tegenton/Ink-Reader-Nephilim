package tegenton.card.parse.lexicon.source.object;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.WordTest;
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
        values = List.of("CARD", "COPY", "PERMANENT", "SPELL", "IT");
    }

    @Test
    void verb() {
        words = ObjectVerb.values();
        values = List.of(
                "ATTACK",
                "BECOME",
                "BLOCK",
                "COST",
                "DIE",
                "ENTER",
                "GAIN",
                "GET",
                "HAVE",
                "IS",
                "LEAVE",
                "TAP");
    }

}
