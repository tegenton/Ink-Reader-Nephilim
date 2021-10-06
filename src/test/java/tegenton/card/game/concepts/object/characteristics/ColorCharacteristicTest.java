package tegenton.card.game.concepts.object.characteristics;

import org.junit.jupiter.api.Test;
import tegenton.card.game.concepts.Color;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ColorCharacteristicTest {
    public static ColorCharacteristic characteristic;

    @Test
    void caseInsensitive() {
        EnumSet<Color> colors = EnumSet.of(Color.white);
        characteristic = ColorCharacteristic.fromString("wHitE");
        assertNotNull(characteristic);
        assertEquals(colors, characteristic.value());
    }

    @Test
    void white() {
        EnumSet<Color> colors = EnumSet.of(Color.white);
        characteristic = ColorCharacteristic.fromString("white");
        assertNotNull(characteristic);
        assertEquals(colors, characteristic.value());
    }

    @Test
    void blue() {
        EnumSet<Color> colors = EnumSet.of(Color.blue);
        characteristic = ColorCharacteristic.fromString("blue");
        assertNotNull(characteristic);
        assertEquals(colors, characteristic.value());
    }

    @Test
    void black() {
        EnumSet<Color> colors = EnumSet.of(Color.black);
        characteristic = ColorCharacteristic.fromString("black");
        assertNotNull(characteristic);
        assertEquals(colors, characteristic.value());
    }

    @Test
    void red() {
        EnumSet<Color> colors = EnumSet.of(Color.red);
        characteristic = ColorCharacteristic.fromString("red");
        assertNotNull(characteristic);
        assertEquals(colors, characteristic.value());
    }

    @Test
    void green() {
        EnumSet<Color> colors = EnumSet.of(Color.green);
        characteristic = ColorCharacteristic.fromString("green");
        assertNotNull(characteristic);
        assertEquals(colors, characteristic.value());
    }

    @Test
    void colorless() {
        EnumSet<Color> colors = EnumSet.noneOf(Color.class);
        characteristic = ColorCharacteristic.fromString("colorless");
        assertNotNull(characteristic);
        assertEquals(colors, characteristic.value());
    }
}
