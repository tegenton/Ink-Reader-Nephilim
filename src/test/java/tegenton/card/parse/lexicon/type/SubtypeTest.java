package tegenton.card.parse.lexicon.type;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.WordTest;
import java.util.List;

public class SubtypeTest extends WordTest {
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
