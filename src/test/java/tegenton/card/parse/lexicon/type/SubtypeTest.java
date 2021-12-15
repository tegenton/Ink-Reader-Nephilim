package tegenton.card.parse.lexicon.type;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.WordTest;
import java.util.List;

public class SubtypeTest extends WordTest {
	@Test
	void creatureType() {
		words = CreatureType.values();
		values = List.of("GOBLIN", "GOLEM", "INSECT", "MERFOLK", "WALL",
						 "ZOMBIE");
	}
}
