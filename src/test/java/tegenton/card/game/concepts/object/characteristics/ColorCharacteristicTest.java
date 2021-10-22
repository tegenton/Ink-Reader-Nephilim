package tegenton.card.game.concepts.object.characteristics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.game.concepts.Color;
import tegenton.card.game.concepts.token.LegendaryToken;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ColorCharacteristicTest {
    public static ColorCharacteristic characteristic;
    public static List<Color> expected;

    @BeforeEach
    void setup() {
        expected = new ArrayList<>();
    }

    @Test
    void caseInsensitive() {
        expected.add(Color.white);
        characteristic = ColorCharacteristic.fromString("wHitE");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void white() {
        expected.add(Color.white);
        characteristic = ColorCharacteristic.fromString("white");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void blue() {
        expected.add(Color.blue);
        characteristic = ColorCharacteristic.fromString("blue");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void black() {
        expected.add(Color.black);
        characteristic = ColorCharacteristic.fromString("black");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void red() {
        expected.add(Color.red);
        characteristic = ColorCharacteristic.fromString("red");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void green() {
        expected.add(Color.green);
        characteristic = ColorCharacteristic.fromString("green");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }

    @Test
    void colorless() {
        characteristic = ColorCharacteristic.fromString("colorless");
        assertNotNull(characteristic);
        assertEquals(expected, characteristic.value());
    }
}
