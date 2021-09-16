package game.type;

import game.type.subtype.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubtypeTest {
    public static Type cardType = Type.creature;
    public static String[] subtypes = {"human", "wizard"};

    @Test
    void artifactHasCorrectSubtype() {
        assertEquals(ArtifactType.class, Type.artifact.getSubtype());
    }

    @Test
    void creatureHasCorrectSubtype() {
        assertEquals(CreatureType.class, cardType.getSubtype());
    }

    @Test
    void enchantmentHasCorrectSubtype() {
        assertEquals(EnchantmentType.class, Type.enchantment.getSubtype());
    }

    @Test
    void landHasCorrectSubtype() {
        assertEquals(LandType.class, Type.land.getSubtype());
    }

    @Test
    void planeHasCorrectSubtype() {
        assertEquals(PlanarType.class, Type.plane.getSubtype());
    }

    @Test
    void planeswalkerHasCorrectSubtype() {
        assertEquals(PlaneswalkerType.class, Type.planeswalker.getSubtype());
    }

    @Test
    void instantHasCorrectSubtype() {
        assertEquals(SpellType.class, Type.instant.getSubtype());
    }

    @Test
    void sorceryHasCorrectSubtype() {
        assertEquals(SpellType.class, Type.sorcery.getSubtype());
    }

    @Test
    void creatureSubtypeContainsHumanWizard() {
        for (String subtype : subtypes) {
            assertTrue(CreatureType.contains(subtype));
        }
    }

    @Test
    void accessContainsFromCardType() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        for (String subtype : subtypes) {
            assertTrue(cardType.contains(subtype));
        }
    }
}
