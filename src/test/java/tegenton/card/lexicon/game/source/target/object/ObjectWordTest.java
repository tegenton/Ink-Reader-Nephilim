package tegenton.card.lexicon.game.source.target.object;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.WordTestTemplate;

import java.util.List;

public class ObjectWordTest extends WordTestTemplate {
    @Test
    void adjective() {
        words = ObjectAdjective.values();
        values = List.of("TOP");
    }

    @Test
    void attribute() {
        words = ObjectAttribute.values();
        values = List.of("FACE", "LOYALTY", "NAME", "POWER", "TOUGHNESS", "VALUE");
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
