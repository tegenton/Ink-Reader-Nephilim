package tegenton.card.parse;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.Subject;

import static org.junit.jupiter.api.Assertions.*;

public class SubjectTokenTest {
    public static SubjectToken subjectToken;

    @Test
    void card() {
        subjectToken = (SubjectToken) SubjectToken.fromString("card").orElse(null);
        assertNotNull(subjectToken);
        assertEquals(Subject.card, subjectToken.getWord());
    }

    @Test
    void cards() {
        subjectToken = (SubjectToken) SubjectToken.fromString("cards").orElse(null);
        assertNotNull(subjectToken);
        assertEquals(Subject.card, subjectToken.getWord());
    }

    @Test
    void invalid() {
        subjectToken = (SubjectToken) SubjectToken.fromString("when").orElse(null);
        assertNull(subjectToken);
    }
}
