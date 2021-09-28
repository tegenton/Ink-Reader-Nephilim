package tegenton.card.game.type.subtype;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class SpellTypeTest {
    public static SpellType type;

    @ParameterizedTest
    @ValueSource(strings = {"Adventure", "Arcane", "Lesson", "Trap"})
    void tokens(String s) {
        type = (SpellType) SpellType.fromString(s).orElse(null);
        assertNotNull(type);
        assertEquals(s, type.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Assembly-Worker", "Shrine", "Ajani", "World"})
    void invalid(String s) {
        type = (SpellType) SpellType.fromString(s).orElse(null);
        assertNull(type);
    }
}
