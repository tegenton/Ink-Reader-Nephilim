package tegenton.card.lexicon.game.type;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypeWordTest {
    public static TypeWord[] words;
    public static List<String> values;

    @AfterEach
    void compare() {
        assertEquals(values.size(), words.length);
        for (int i = 0; i < words.length; i++) {
            assertEquals(values.get(i), words[i].toString());
        }
    }

    @Test
    void card() {
        words = CardType.values();
        values = List.of("ARTIFACT", "CREATURE", "ENCHANTMENT", "INSTANT",
                "LAND", "PLANESWALKER", "SORCERY");
    }

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
