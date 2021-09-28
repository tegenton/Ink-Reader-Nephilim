package tegenton.card.game.type.subtype;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EnchantmentTypeTest {
    public static EnchantmentType type;

    @ParameterizedTest
    @ValueSource(strings = {"Shard"})
    void tokens(String s) {
        type = (EnchantmentType) EnchantmentType.fromString(s).orElse(null);
        assertNotNull(type);
        assertEquals(s, type.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Aura",
            "Cartouche",
            "Curse",
            "Rune",
            "Saga",
            "Shrine",
    })
    void misc(String s) {
        type = (EnchantmentType) EnchantmentType.fromString(s).orElse(null);
        assertNotNull(type);
        assertEquals(s, type.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Assembly-Worker", "Treasure", "Ajani", "World"})
    void invalid(String s) {
        type = (EnchantmentType) EnchantmentType.fromString(s).orElse(null);
        assertNull(type);
    }
}
