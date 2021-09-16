package game.type;

import game.type.subtype.CreatureType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubtypeTest {
    public static Type cardType = Type.creature;
    public static String[] subtypes = {"human", "wizard"};

    @Test
    void artifactHasCorrectSubtype() {
        assertTrue(Type.artifact.fromString("Treasure").isPresent());
    }

    @Test
    void creatureHasCorrectSubtype() {
        assertTrue(Type.creature.fromString("Assembly-Worker").isPresent());
    }

    @Test
    void enchantmentHasCorrectSubtype() {
        assertTrue(Type.enchantment.fromString("Shrine").isPresent());
    }

    @Test
    void landHasCorrectSubtype() {
        assertTrue(Type.land.fromString("Urza's").isPresent());
    }

    @Test
    void planeHasCorrectSubtype() {
        assertTrue(Type.plane.fromString("Serra's Realm").isPresent());
    }

    @Test
    void planeswalkerHasCorrectSubtype() {
        assertTrue(Type.planeswalker.fromString("Ajani").isPresent());
    }

    @Test
    void instantHasCorrectSubtype() {
        assertTrue(Type.instant.fromString("Arcane").isPresent());
    }

    @Test
    void sorceryHasCorrectSubtype() {
        assertTrue(Type.sorcery.fromString("Arcane").isPresent());
    }

    @Test
    void creatureSubtypeContainsHumanWizard() {
        for (String subtype : subtypes) {
            assertTrue(CreatureType.fromString(subtype).isPresent());
        }
    }

    @Test
    void accessContainsFromCardType() {
        for (String subtype : subtypes) {
            assertTrue(cardType.fromString(subtype).isPresent());
        }
    }
}
