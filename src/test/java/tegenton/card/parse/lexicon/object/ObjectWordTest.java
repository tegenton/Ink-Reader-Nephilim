package tegenton.card.parse.lexicon.object;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.WordTest;
import java.util.List;

public class ObjectWordTest extends WordTest {
    @Test
    void object() {
        words = ObjectNoun.values();
        values = List.of("CARD", "COPY", "PERMANENT", "SPELL", "IT");
    }

    @Test
    void objectVerb() {
        words = ObjectVerb.values();
        values = List.of("ATTACK", "BLOCK", "DIE", "ENTER", "LEAVE", "TAP");
    }

}
