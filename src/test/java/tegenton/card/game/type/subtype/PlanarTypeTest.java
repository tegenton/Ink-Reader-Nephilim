package tegenton.card.game.type.subtype;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class PlanarTypeTest {
    public static PlanarType type;

    @ParameterizedTest
    @ValueSource(strings = {
            "Alara",
            "Arkhos",
            "Azgol",
            "Belenon",
            "Bolas's Meditation Realm",
            "Dominaria",
            "Equilor",
            "Ergamon",
            "Fabacin",
            "Innistrad",
            "Iquatana",
            "Ir",
            "Kaldheim",
            "Kamigawa",
            "Karsus",
            "Kephalai",
            "Kinshala",
            "Kolbahan",
            "Kyneth",
            "Lorwyn",
            "Luvion",
            "Mercadia",
            "Mirrodin",
            "Moag",
            "Mongseng",
            "Muraganda",
            "New Phyrexia",
            "Phyrexia",
            "Pyrulea",
            "Rabiah",
            "Rath",
            "Ravnica",
            "Regatha",
            "Segovia",
            "Serra's Realm",
            "Shadowmoor",
            "Shandalar",
            "Ulgrotha",
            "Valla",
            "Vryn",
            "Wildfire",
            "Xerex",
            "Zendikar"})
    void tokens(String s) {
        type = (PlanarType) PlanarType.fromString(s).orElse(null);
        assertNotNull(type);
        assertEquals(s, type.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Assembly-Worker", "Treasure", "Ajani", "World"})
    void invalid(String s) {
        type = (PlanarType) PlanarType.fromString(s).orElse(null);
        assertNull(type);
    }
}
