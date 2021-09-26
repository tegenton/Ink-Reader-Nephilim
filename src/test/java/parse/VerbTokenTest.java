package parse;

import org.junit.jupiter.api.Test;
import parse.lexicon.Verb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VerbTokenTest {
    public static VerbToken verbToken;

    @Test
    void draw() {
        verbToken = (VerbToken) VerbToken.fromString("draw").orElse(null);
        assertNotNull(verbToken);
        assertEquals(Verb.draw, verbToken.getWord());
    }
}
