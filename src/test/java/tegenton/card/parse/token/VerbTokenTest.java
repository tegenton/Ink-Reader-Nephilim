package tegenton.card.parse.token;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tegenton.card.parse.token.lexicon.Verb;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VerbTokenTest {
    public static VerbToken verbToken;

    @Test
    void draw() {
        verbToken = (VerbToken) VerbToken.fromString("draw").orElse(null);
        assertNotNull(verbToken);
        Assertions.assertEquals(Verb.draw, verbToken.getWord());
    }

    @Test
    void invalid() {
        verbToken = (VerbToken) VerbToken.fromString("when").orElse(null);
        assertNull(verbToken);
    }
}
