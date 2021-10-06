package tegenton.card.game.concepts.object.characteristics;

import org.junit.jupiter.api.Test;
import tegenton.card.game.type.SuperType;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SuperTypeCharacteristicTest {
    public static SuperTypeCharacteristic characteristic;

    @Test
    void caseInsensitive() {
        EnumSet<SuperType> types = EnumSet.of(SuperType.legendary);
        characteristic = SuperTypeCharacteristic.fromString("lEgEnDaRy");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void legendary() {
        EnumSet<SuperType> types = EnumSet.of(SuperType.legendary);
        characteristic = SuperTypeCharacteristic.fromString("legendary");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void basic() {
        EnumSet<SuperType> types = EnumSet.of(SuperType.basic);
        characteristic = SuperTypeCharacteristic.fromString("basic");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void snow() {
        EnumSet<SuperType> types = EnumSet.of(SuperType.snow);
        characteristic = SuperTypeCharacteristic.fromString("snow");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void ongoing() {
        EnumSet<SuperType> types = EnumSet.of(SuperType.ongoing);
        characteristic = SuperTypeCharacteristic.fromString("ongoing");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void world() {
        EnumSet<SuperType> types = EnumSet.of(SuperType.world);
        characteristic = SuperTypeCharacteristic.fromString("world");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

}
