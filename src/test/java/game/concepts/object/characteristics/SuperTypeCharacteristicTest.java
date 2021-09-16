package game.concepts.object.characteristics;

import game.type.SuperType;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SuperTypeCharacteristicTest {
    public static Characteristic characteristic;

    @Test
    void caseInsensitive() {
        EnumSet<SuperType> types = EnumSet.of(SuperType.legendary);
        characteristic = SuperTypeCharacteristic.fromString("lEgEnDaRy").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void legendary() {
        EnumSet<SuperType> types = EnumSet.of(SuperType.legendary);
        characteristic = SuperTypeCharacteristic.fromString("legendary").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void basic() {
        EnumSet<SuperType> types = EnumSet.of(SuperType.basic);
        characteristic = SuperTypeCharacteristic.fromString("basic").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void snow() {
        EnumSet<SuperType> types = EnumSet.of(SuperType.snow);
        characteristic = SuperTypeCharacteristic.fromString("snow").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void ongoing() {
        EnumSet<SuperType> types = EnumSet.of(SuperType.ongoing);
        characteristic = SuperTypeCharacteristic.fromString("ongoing").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void world() {
        EnumSet<SuperType> types = EnumSet.of(SuperType.world);
        characteristic = SuperTypeCharacteristic.fromString("world").orElse(null);
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

}
