package game.concepts.object.characteristics;

import game.type.subtype.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SubtypeCharacteristicTest {
    public static Characteristic characteristic;
    public static List<Subtype> types;

    @BeforeEach
    void setup() {
        types = new ArrayList<>();
    }

    @Test
    void caseInsensitive() {
        types.add(CreatureType.goblin);
        characteristic = SubtypeCharacteristic.fromString("gObLiN").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void artifact() {
        types.add(ArtifactType.treasure);
        characteristic = SubtypeCharacteristic.fromString("treasure").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void creature() {
        types.add(CreatureType.goblin);
        characteristic = SubtypeCharacteristic.fromString("goblin").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void enchantment() {
        types.add(EnchantmentType.cartouche);
        characteristic = SubtypeCharacteristic.fromString("cartouche").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void land() {
        types.add(LandType.gate);
        characteristic = SubtypeCharacteristic.fromString("gate").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void plane() {
        types.add(PlanarType.wildfire);
        characteristic = SubtypeCharacteristic.fromString("wildfire").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void planeswalker() {
        types.add(PlaneswalkerType.freyalise);
        characteristic = SubtypeCharacteristic.fromString("freyalise").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void spell() {
        types.add(SpellType.adventure);
        characteristic = SubtypeCharacteristic.fromString("adventure").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }
}
