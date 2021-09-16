package game.type.subtype;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LandTypeTest {
    public static LandType type;

    @ParameterizedTest
    @ValueSource(strings = {"plains", "island", "swamp", "mountain", "forest"})
    void basics(String s) {
        type = LandType.valueOf(s);
        assertTrue(type.isBasic());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "desert",
            "gate",
            "lair",
            "locus"})
    void misc(String s) {
        type = LandType.valueOf(s);
        assertEquals(s, type.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            //TODO: "urzas",
            "mine",
            //TODO: "powerplant",
            "tower"})
    void urzas(String s) {
        type = LandType.valueOf(s);
        assertEquals(s, type.getName());
    }
}
