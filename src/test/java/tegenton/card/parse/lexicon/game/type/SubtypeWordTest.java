package tegenton.card.parse.lexicon.game.type;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.WordTest;
import tegenton.card.parse.lexicon.game.type.CreatureType;
import tegenton.card.parse.lexicon.game.type.EnchantmentType;
import tegenton.card.parse.lexicon.game.type.LandType;
import java.util.List;

public class SubtypeWordTest extends WordTest {
    @Test
    void creature() {
        words = CreatureType.values();
        values = List.of("GOBLIN", "GOLEM", "INSECT", "MERFOLK", "WALL",
                         "ZOMBIE");
    }

    @Test
    void enchantment() {
        words = EnchantmentType.values();
        values = List.of("AURA");
    }

    @Test
    void land() {
        words = LandType.values();
        values = List.of("PLAINS", "ISLAND", "SWAMP", "MOUNTAIN", "FOREST");
    }
}
