package tegenton.card.parse.token.lexicon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class QualifierTest {
    Qualifier qualifier;

    @ParameterizedTest
    @ValueSource(strings = {"Enchanted"})
    void valid(String s) {
        qualifier = Qualifier.fromString(s);
        assertNotNull(qualifier);
        assertEquals(s, qualifier.getWord());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Then", "Until", "If"})
    void invalid(String s) {
        qualifier = Qualifier.fromString(s);
        assertNull(qualifier);
    }
}
