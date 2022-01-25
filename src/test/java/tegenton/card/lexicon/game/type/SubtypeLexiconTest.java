package tegenton.card.lexicon.game.type;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tegenton.card.lexicon.LexiconTest;

public class SubtypeLexiconTest extends LexiconTest {
    @ParameterizedTest
    @EnumSource(CreatureType.class)
    void creature(CreatureType type) {
        word = type;
    }

    @ParameterizedTest
    @EnumSource(EnchantmentType.class)
    void enchantment(EnchantmentType type) {
        word = type;
    }

    @ParameterizedTest
    @EnumSource(LandType.class)
    void land(LandType type) {
        word = type;
    }

}
