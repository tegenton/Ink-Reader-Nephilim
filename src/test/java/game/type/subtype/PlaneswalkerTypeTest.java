package game.type.subtype;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class PlaneswalkerTypeTest {
    public static PlaneswalkerType type;

    @ParameterizedTest
    @ValueSource(strings = {
            "Ajani",
            "Aminatou",
            "Angrath",
            "Arlinn",
            "Ashiok",
            "Basri",
            "Bolas",
            "Calix",
            "Chandra",
            "Dack",
            "Dakkon",
            "Daretti",
            "Davriel",
            "Dihada",
            "Domri",
            "Dovin",
            "Elspeth",
            "Estrid",
            "Freyalise",
            "Garruk",
            "Gideon",
            "Grist",
            "Huatli",
            "Jace",
            "Jaya",
            "Jeska",
            "Karn",
            "Kasmina",
            "Kaya",
            "Kiora",
            "Koth",
            "Liliana",
            "Lukka",
            "Nahiri",
            "Narset",
            "Niko",
            "Nissa",
            "Nixilis",
            "Oko",
            "Ral",
            "Rowan",
            "Saheeli",
            "Samut",
            "Sarkhan",
            "Serra",
            "Sorin",
            "Szat",
            "Tamiyo",
            "Teferi",
            "Teyo",
            "Tezzeret",
            "Tibalt",
            "Tyvar",
            "Ugin",
            "Venser",
            "Vivien",
            "Vraska",
            "Will",
            "Windgrace",
            "Wrenn",
            "Xenagos",
            "Yanggu",
            "Yanling"
    })
    void tokens(String s) {
        type = (PlaneswalkerType) PlaneswalkerType.fromString(s).orElse(null);
        assertNotNull(type);
        assertEquals(s, type.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Assembly-Worker", "Treasure", "Shrine", "World"})
    void invalid(String s) {
        type = (PlaneswalkerType) PlaneswalkerType.fromString(s).orElse(null);
        assertNull(type);
    }
}
