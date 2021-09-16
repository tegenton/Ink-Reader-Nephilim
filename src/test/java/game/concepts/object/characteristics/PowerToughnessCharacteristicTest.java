package game.concepts.object.characteristics;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PowerToughnessCharacteristicTest {
    public static Characteristic result;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    void power(int stat) {
        result = PowerToughnessCharacteristic.fromString(stat + "/1").orElse(null);
        assertNotNull(result);
        assertArrayEquals(new int[]{stat, 1}, (int[]) result.value());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    void toughness(int stat) {
        result = PowerToughnessCharacteristic.fromString("1/" + stat).orElse(null);
        assertNotNull(result);
        assertArrayEquals(new int[]{1, stat}, (int[]) result.value());
    }
}
