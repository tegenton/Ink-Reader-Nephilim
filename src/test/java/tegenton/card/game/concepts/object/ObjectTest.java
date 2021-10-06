package tegenton.card.game.concepts.object;

import org.junit.jupiter.api.Test;
import tegenton.card.game.concepts.card.Card;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObjectTest {
    public static Object object;

    @Test
    void valuesNullByDefault() {
        object = new Card();
        assertTrue(object.getName().isEmpty());
        assertTrue(object.getColor().isEmpty());
        // TODO: assertTrue(object.getCharacteristic(CharacteristicName.manaCost).isEmpty());
        assertTrue(object.getColorIndicator().isEmpty());
        assertTrue(object.getSuperTypes().isEmpty());
        assertTrue(object.getCardTypes().isEmpty());
        assertTrue(object.getSubtypes().isEmpty());
        // TODO: assertTrue(object.getRulesText().isEmpty());
        // TODO: assertTrue(object.getCharacteristic(CharacteristicName.abilities).isEmpty());
        assertTrue(object.getPower().isEmpty());
        assertTrue(object.getToughness().isEmpty());
        assertTrue(object.getLoyalty().isEmpty());
        assertTrue(object.getHandMod().isEmpty());
        assertTrue(object.getLifeMod().isEmpty());
    }
}
