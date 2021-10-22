package tegenton.card.parse.token;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tegenton.card.parse.token.lexicon.TriggeredAbility;
import static org.junit.jupiter.api.Assertions.*;

class TriggeredAbilityTokenTest {
    TriggeredAbilityToken triggeredAbilityToken;

    @ParameterizedTest
    @ValueSource(strings = {"When", "Whenever", "At"})
    void valid(String s) {
        triggeredAbilityToken = TriggeredAbilityToken.fromString(s);
        assertNotNull(triggeredAbilityToken);
        assertEquals(TriggeredAbility.fromString(s), triggeredAbilityToken.getWord());
    }

    @Test
    void invalid() {
        triggeredAbilityToken = TriggeredAbilityToken.fromString("Quality");
        assertNull(triggeredAbilityToken);
    }

}
