package tegenton.card.parse.token;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tegenton.card.parse.token.lexicon.Subject;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SubjectTokenTest {
    public static SubjectToken subjectToken;

    @Test
    void card() {
        subjectToken = (SubjectToken) SubjectToken.fromString("card").orElse(null);
        assertNotNull(subjectToken);
        Assertions.assertEquals(Subject.card, subjectToken.getWord());
    }

    @Test
    void cards() {
        subjectToken = (SubjectToken) SubjectToken.fromString("cards").orElse(null);
        assertNotNull(subjectToken);
        Assertions.assertEquals(Subject.card, subjectToken.getWord());
    }

    @Test
    void invalid() {
        subjectToken = (SubjectToken) SubjectToken.fromString("when").orElse(null);
        assertNull(subjectToken);
    }
}
