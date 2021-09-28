package tegenton.card.game.type.subtype;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ArtifactTypeTest {
    public static ArtifactType type;

    @ParameterizedTest
    @ValueSource(strings = {"Clue", "Food", "Gold", "Treasure"})
    void tokens(String s) {
        type = (ArtifactType) ArtifactType.fromString(s).orElse(null);
        assertNotNull(type);
        assertEquals(s, type.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Contraption",
            "Equipment",
            "Fortification",
            "Vehicle"
    })
    void misc(String s) {
        type = (ArtifactType) ArtifactType.fromString(s).orElse(null);
        assertNotNull(type);
        assertEquals(s, type.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Assembly-Worker", "Shrine", "Ajani", "World"})
    void invalid(String s) {
        type = (ArtifactType) ArtifactType.fromString(s).orElse(null);
        assertNull(type);
    }
}
