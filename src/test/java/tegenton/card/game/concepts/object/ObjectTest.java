package tegenton.card.game.concepts.object;

import tegenton.card.game.concepts.card.Card;
import tegenton.card.game.concepts.object.characteristics.CharacteristicName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObjectTest {
    public static Object object;

    @Test
    void valuesNullByDefault() {
        object = new Card();
        assertTrue(object.getCharacteristic(CharacteristicName.name).isEmpty());
        assertTrue(object.getCharacteristic(CharacteristicName.color).isEmpty());
        // TODO: assertTrue(object.getCharacteristic(CharacteristicName.manaCost).isEmpty());
        assertTrue(object.getCharacteristic(CharacteristicName.colorIndicator).isEmpty());
        assertTrue(object.getCharacteristic(CharacteristicName.superType).isEmpty());
        assertTrue(object.getCharacteristic(CharacteristicName.cardType).isEmpty());
        assertTrue(object.getCharacteristic(CharacteristicName.subtype).isEmpty());
        assertTrue(object.getCharacteristic(CharacteristicName.rulesText).isEmpty());
        // TODO: assertTrue(object.getCharacteristic(CharacteristicName.abilities).isEmpty());
        assertTrue(object.getCharacteristic(CharacteristicName.powerToughness).isEmpty());
        assertTrue(object.getCharacteristic(CharacteristicName.loyalty).isEmpty());
        assertTrue(object.getCharacteristic(CharacteristicName.handMod).isEmpty());
        assertTrue(object.getCharacteristic(CharacteristicName.lifeMod).isEmpty());
    }
}
