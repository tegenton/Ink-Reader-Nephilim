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
        subjectToken = SubjectToken.fromString("card");
        assertNotNull(subjectToken);
        Assertions.assertEquals(Subject.card, subjectToken.getWord());
    }

    @Test
    void cards() {
        subjectToken = SubjectToken.fromString("cards");
        assertNotNull(subjectToken);
        Assertions.assertEquals(Subject.card, subjectToken.getWord());
    }

    @Test
    void invalid() {
        subjectToken = SubjectToken.fromString("when");
        assertNull(subjectToken);
    }
}
