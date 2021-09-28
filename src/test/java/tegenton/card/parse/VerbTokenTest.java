package tegenton.card.parse;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.Verb;

import static org.junit.jupiter.api.Assertions.*;

public class VerbTokenTest {
    public static VerbToken verbToken;

    @Test
    void draw() {
        verbToken = (VerbToken) VerbToken.fromString("draw").orElse(null);
        assertNotNull(verbToken);
        assertEquals(Verb.draw, verbToken.getWord());
    }

    @Test
    void invalid() {
        verbToken = (VerbToken) VerbToken.fromString("when").orElse(null);
        assertNull(verbToken);
    }
}
