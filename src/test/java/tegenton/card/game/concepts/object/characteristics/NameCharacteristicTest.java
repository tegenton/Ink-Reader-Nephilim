package tegenton.card.game.concepts.object.characteristics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NameCharacteristicTest {
    public static NameCharacteristic characteristic;

    @Test
    void caseInsensitive() {
        characteristic = NameCharacteristic.fromString("named Kaldra");
        assertNotNull(characteristic);
        assertEquals(new ArrayList<>(Collections.singleton("Kaldra")), characteristic.value());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Marit Lage", "Icingdeath, Frost Tongue", "Minsc, Beloved Hamster", "Stangg Twin"})
    void names(String name) {
        characteristic = NameCharacteristic.fromString("named " + name);
        assertNotNull(characteristic);
        assertEquals(new ArrayList<>(Collections.singleton(name)), characteristic.value());
    }
}
