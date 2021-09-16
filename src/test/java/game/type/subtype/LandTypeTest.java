package game.type.subtype;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class LandTypeTest {
    public static LandType type;

    @ParameterizedTest
    @ValueSource(strings = {"Plains", "Island", "Swamp", "Mountain", "Forest"})
    void basics(String s) {
        type = (LandType) LandType.fromString(s).orElse(null);
        assertNotNull(type);
        assertTrue(type.isBasic());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Desert",
            "Gate",
            "Lair",
            "Locus"})
    void misc(String s) {
        type = (LandType) LandType.fromString(s).orElse(null);
        assertNotNull(type);
        assertEquals(s, type.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Urza's",
            "Mine",
            "Power-Plant",
            "Tower"})
    void urzas(String s) {
        type = (LandType) LandType.fromString(s).orElse(null);
        assertNotNull(type);
        assertEquals(s, type.getName());
    }
}
