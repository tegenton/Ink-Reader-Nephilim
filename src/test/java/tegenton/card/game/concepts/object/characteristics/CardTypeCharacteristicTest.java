package tegenton.card.game.concepts.object.characteristics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.game.type.Type;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CardTypeCharacteristicTest {
    public static CardTypeCharacteristic characteristic;
    public static List<Type> expected;

    @BeforeEach
    void setup() {
        expected = new ArrayList<>();
    }

    @Test
    void caseInsensitive() {
        expected.add(Type.artifact);
        characteristic = CardTypeCharacteristic.fromString("aRtIfAct");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void artifact() {
        expected.add(Type.artifact);
        characteristic = CardTypeCharacteristic.fromString("artifact");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void conspiracy() {
        expected.add(Type.conspiracy);
        characteristic = CardTypeCharacteristic.fromString("conspiracy");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void creature() {
        expected.add(Type.creature);
        characteristic = CardTypeCharacteristic.fromString("creature");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void enchantment() {
        expected.add(Type.enchantment);
        characteristic = CardTypeCharacteristic.fromString("enchantment");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void instant() {
        expected.add(Type.instant);
        characteristic = CardTypeCharacteristic.fromString("instant");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void land() {
        expected.add(Type.land);
        characteristic = CardTypeCharacteristic.fromString("land");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void phenomenon() {
        expected.add(Type.phenomenon);
        characteristic = CardTypeCharacteristic.fromString("phenomenon");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void plane() {
        expected.add(Type.plane);
        characteristic = CardTypeCharacteristic.fromString("plane");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void planeswalker() {
        expected.add(Type.planeswalker);
        characteristic = CardTypeCharacteristic.fromString("planeswalker");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void scheme() {
        expected.add(Type.scheme);
        characteristic = CardTypeCharacteristic.fromString("scheme");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void sorcery() {
        expected.add(Type.sorcery);
        characteristic = CardTypeCharacteristic.fromString("sorcery");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void tribal() {
        expected.add(Type.tribal);
        characteristic = CardTypeCharacteristic.fromString("tribal");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void vanguard() {
        expected.add(Type.vanguard);
        characteristic = CardTypeCharacteristic.fromString("vanguard");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }
}
