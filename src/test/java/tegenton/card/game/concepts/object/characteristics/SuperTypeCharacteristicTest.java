package tegenton.card.game.concepts.object.characteristics;

import org.junit.jupiter.api.Test;
import tegenton.card.game.type.SuperType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SuperTypeCharacteristicTest {
    public static SuperTypeCharacteristic characteristic;

    @Test
    void caseInsensitive() {
        List<SuperType> types = List.of(SuperType.legendary);
        characteristic = SuperTypeCharacteristic.fromString("lEgEnDaRy");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void legendary() {
        List<SuperType> types = List.of(SuperType.legendary);
        characteristic = SuperTypeCharacteristic.fromString("legendary");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void basic() {
        List<SuperType> types = List.of(SuperType.basic);
        characteristic = SuperTypeCharacteristic.fromString("basic");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void snow() {
        List<SuperType> types = List.of(SuperType.snow);
        characteristic = SuperTypeCharacteristic.fromString("snow");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void ongoing() {
        List<SuperType> types = List.of(SuperType.ongoing);
        characteristic = SuperTypeCharacteristic.fromString("ongoing");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

    @Test
    void world() {
        List<SuperType> types = List.of(SuperType.world);
        characteristic = SuperTypeCharacteristic.fromString("world");
        assertNotNull(characteristic);
        assertEquals(types, characteristic.value());
    }

}
