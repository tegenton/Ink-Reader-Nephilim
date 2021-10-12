package tegenton.card.parse.ability;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AbilityTest {
    public static Ability ability;

    @Test
    void animateWall() {
        ability = Ability.fromString("Enchant Wall");
        assertNotNull(ability);
        assertTrue(EnchantAbility.class.isAssignableFrom(ability.getClass()));
        ability = Ability.fromString("Enchanted Wall can attack as though it didn't have defender.");
        assertNotNull(ability);
        assertTrue(StaticAbility.class.isAssignableFrom(ability.getClass()));
    }
}
