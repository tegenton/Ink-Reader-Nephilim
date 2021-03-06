package tegenton.card.game.concepts.object.characteristics;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PowerToughnessCharacteristicTest {
    public static PowerToughnessCharacteristic result;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    void power(int stat) {
        result = PowerToughnessCharacteristic.fromString(stat + "/1");
        assertNotNull(result);
        assertIterableEquals(List.of(stat, 1), result.value());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    void toughness(int stat) {
        result = PowerToughnessCharacteristic.fromString("1/" + stat);
        assertNotNull(result);
        assertIterableEquals(List.of(1, stat), result.value());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1/1/1", "*/*"})
    void invalid(String s) {
        result = PowerToughnessCharacteristic.fromString(s);
        assertNull(result);
    }
}
