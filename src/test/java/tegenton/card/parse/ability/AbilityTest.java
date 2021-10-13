package tegenton.card.parse.ability;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.token.TokenStream;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AbilityTest {
    public static Ability ability;

    @Test
    void animateWall() {
        ability = Ability.fromStream(new TokenStream("Enchant Wall"));
        assertNotNull(ability);
        assertTrue(ability instanceof EnchantAbility);
        ability = Ability.fromStream(new TokenStream("Enchanted Wall can attack as though it didn't have defender."));
        assertNotNull(ability);
        assertTrue(ability instanceof StaticAbility);
    }

    @Test
    void karma() {
        ability = Ability.fromStream(new TokenStream("At the beginning of each player's upkeep, ~ deals damage to that player equal to the number of Swamps they control."));
        assertNotNull(ability);
        assertTrue(ability instanceof TriggeredAbility);
    }
}
