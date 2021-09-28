package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.type.Type;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CardTypeCharacteristicTest {
    public static Characteristic characteristic;

    @Test
    void caseInsensitive() {
        EnumSet<Type> types = EnumSet.of(Type.artifact);
        characteristic = CardTypeCharacteristic.fromString("aRtIfAct").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void artifact() {
        EnumSet<Type> types = EnumSet.of(Type.artifact);
        characteristic = CardTypeCharacteristic.fromString("artifact").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void conspiracy() {
        EnumSet<Type> types = EnumSet.of(Type.conspiracy);
        characteristic = CardTypeCharacteristic.fromString("conspiracy").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void creature() {
        EnumSet<Type> types = EnumSet.of(Type.creature);
        characteristic = CardTypeCharacteristic.fromString("creature").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void enchantment() {
        EnumSet<Type> types = EnumSet.of(Type.enchantment);
        characteristic = CardTypeCharacteristic.fromString("enchantment").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void instant() {
        EnumSet<Type> types = EnumSet.of(Type.instant);
        characteristic = CardTypeCharacteristic.fromString("instant").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void land() {
        EnumSet<Type> types = EnumSet.of(Type.land);
        characteristic = CardTypeCharacteristic.fromString("land").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void phenomenon() {
        EnumSet<Type> types = EnumSet.of(Type.phenomenon);
        characteristic = CardTypeCharacteristic.fromString("phenomenon").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void plane() {
        EnumSet<Type> types = EnumSet.of(Type.plane);
        characteristic = CardTypeCharacteristic.fromString("plane").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void planeswalker() {
        EnumSet<Type> types = EnumSet.of(Type.planeswalker);
        characteristic = CardTypeCharacteristic.fromString("planeswalker").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void scheme() {
        EnumSet<Type> types = EnumSet.of(Type.scheme);
        characteristic = CardTypeCharacteristic.fromString("scheme").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void sorcery() {
        EnumSet<Type> types = EnumSet.of(Type.sorcery);
        characteristic = CardTypeCharacteristic.fromString("sorcery").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void tribal() {
        EnumSet<Type> types = EnumSet.of(Type.tribal);
        characteristic = CardTypeCharacteristic.fromString("tribal").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void vanguard() {
        EnumSet<Type> types = EnumSet.of(Type.vanguard);
        characteristic = CardTypeCharacteristic.fromString("vanguard").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }
}
