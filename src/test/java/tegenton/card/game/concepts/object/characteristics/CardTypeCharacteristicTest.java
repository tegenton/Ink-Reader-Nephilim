package tegenton.card.game.concepts.object.characteristics;

import org.junit.jupiter.api.Test;
import tegenton.card.game.type.Type;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CardTypeCharacteristicTest {
    public static CardTypeCharacteristic characteristic;

    @Test
    void caseInsensitive() {
        EnumSet<Type> types = EnumSet.of(Type.artifact);
        characteristic = CardTypeCharacteristic.fromString("aRtIfAct");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void artifact() {
        EnumSet<Type> types = EnumSet.of(Type.artifact);
        characteristic = CardTypeCharacteristic.fromString("artifact");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void conspiracy() {
        EnumSet<Type> types = EnumSet.of(Type.conspiracy);
        characteristic = CardTypeCharacteristic.fromString("conspiracy");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void creature() {
        EnumSet<Type> types = EnumSet.of(Type.creature);
        characteristic = CardTypeCharacteristic.fromString("creature");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void enchantment() {
        EnumSet<Type> types = EnumSet.of(Type.enchantment);
        characteristic = CardTypeCharacteristic.fromString("enchantment");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void instant() {
        EnumSet<Type> types = EnumSet.of(Type.instant);
        characteristic = CardTypeCharacteristic.fromString("instant");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void land() {
        EnumSet<Type> types = EnumSet.of(Type.land);
        characteristic = CardTypeCharacteristic.fromString("land");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void phenomenon() {
        EnumSet<Type> types = EnumSet.of(Type.phenomenon);
        characteristic = CardTypeCharacteristic.fromString("phenomenon");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void plane() {
        EnumSet<Type> types = EnumSet.of(Type.plane);
        characteristic = CardTypeCharacteristic.fromString("plane");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void planeswalker() {
        EnumSet<Type> types = EnumSet.of(Type.planeswalker);
        characteristic = CardTypeCharacteristic.fromString("planeswalker");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void scheme() {
        EnumSet<Type> types = EnumSet.of(Type.scheme);
        characteristic = CardTypeCharacteristic.fromString("scheme");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void sorcery() {
        EnumSet<Type> types = EnumSet.of(Type.sorcery);
        characteristic = CardTypeCharacteristic.fromString("sorcery");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void tribal() {
        EnumSet<Type> types = EnumSet.of(Type.tribal);
        characteristic = CardTypeCharacteristic.fromString("tribal");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void vanguard() {
        EnumSet<Type> types = EnumSet.of(Type.vanguard);
        characteristic = CardTypeCharacteristic.fromString("vanguard");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }
}
