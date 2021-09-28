package tegenton.card.game.concepts.object.characteristics;

import tegenton.card.game.concepts.Color;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ColorCharacteristicTest {
    public static Characteristic characteristic;

    @Test
    void caseInsensitive() {
        EnumSet<Color> colors = EnumSet.of(Color.white);
        characteristic = ColorCharacteristic.fromString("wHitE").orElse(null);
        assertNotNull(characteristic);
        assertEquals(colors, characteristic.value());
    }

    @Test
    void white() {
        EnumSet<Color> colors = EnumSet.of(Color.white);
        characteristic = ColorCharacteristic.fromString("white").orElse(null);
        assertNotNull(characteristic);
        assertEquals(colors, characteristic.value());
    }

    @Test
    void blue() {
        EnumSet<Color> colors = EnumSet.of(Color.blue);
        characteristic = ColorCharacteristic.fromString("blue").orElse(null);

        assertNotNull(characteristic);
        assertEquals(colors, characteristic.value());
    }

    @Test
    void black() {
        EnumSet<Color> colors = EnumSet.of(Color.black);
        characteristic = ColorCharacteristic.fromString("black").orElse(null);
        assertNotNull(characteristic);
        assertEquals(colors, characteristic.value());
    }

    @Test
    void red() {
        EnumSet<Color> colors = EnumSet.of(Color.red);
        characteristic = ColorCharacteristic.fromString("red").orElse(null);
        assertNotNull(characteristic);
        assertEquals(colors, characteristic.value());
    }

    @Test
    void green() {
        EnumSet<Color> colors = EnumSet.of(Color.green);
        characteristic = ColorCharacteristic.fromString("green").orElse(null);
        assertNotNull(characteristic);
        assertEquals(colors, characteristic.value());
    }

    @Test
    void colorless() {
        EnumSet<Color> colors = EnumSet.noneOf(Color.class);
        characteristic = ColorCharacteristic.fromString("colorless").orElse(null);
        assertNotNull(characteristic);
        assertEquals(colors, characteristic.value());
    }
}
