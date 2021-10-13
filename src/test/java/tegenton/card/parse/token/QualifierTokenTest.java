package tegenton.card.parse.token;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.token.lexicon.Qualifier;
import static org.junit.jupiter.api.Assertions.*;

class QualifierTokenTest {
    QualifierToken qualifierToken;

    @Test
    void valid() {
        qualifierToken = QualifierToken.fromString("Enchanted");
        assertNotNull(qualifierToken);
        assertEquals(Qualifier.enchanted, qualifierToken.getWord());
    }

    @Test
    void invalid() {
        qualifierToken = QualifierToken.fromString("Quality");
        assertNull(qualifierToken);
    }
}
