package tegenton.card.parse.token.lexicon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class TriggeredAbilityTest {
    TriggeredAbility triggeredAbility;

    @ParameterizedTest
    @ValueSource(strings = {"When", "Whenever", "At"})
    void valid(String s) {
        triggeredAbility = TriggeredAbility.fromString(s);
        assertNotNull(triggeredAbility);
        assertEquals(s, triggeredAbility.getWord());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Then", "Until", "If"})
    void invalid(String s) {
        triggeredAbility = TriggeredAbility.fromString(s);
        assertNull(triggeredAbility);
    }
}
