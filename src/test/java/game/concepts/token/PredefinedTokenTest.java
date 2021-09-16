package game.concepts.token;

import game.concepts.Color;
import game.concepts.object.characteristics.CharacteristicName;
import game.type.Type;
import game.type.subtype.ArtifactType;
import game.type.subtype.CreatureType;
import game.type.subtype.EnchantmentType;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PredefinedTokenTest {
    /*111.10a A Treasure token is a colorless Treasure artifact token with “{T}, Sacrifice this artifact:
Add one mana of any color.”
111.10b A Food token is a colorless Food artifact token with “{2}, {T}, Sacrifice this artifact: You
gain 3 life.”
111.10c A Gold token is a colorless Gold artifact token with “Sacrifice this artifact: Add one mana
of any color.”
111.10d A Walker token is a 2/2 black Zombie creature token named Walker.
111.10e A Shard token is a colorless Shard enchantment token with “{2}, Sacrifice this
enchantment: Scry 1, then draw a card.”
111.10f A Clue token is a colorless Clue artifact token with “{2}, Sacrifice this artifact: Draw a
card.”*/
    public static Token token;

    @Test
    void treasure() {
        token = PredefinedToken.create("Treasure");
        assertNotNull(token);
        assertTrue(token.getCharacteristic(CharacteristicName.color).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.cardType).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.subtype).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.name).isPresent());
        assertEquals(EnumSet.noneOf(Color.class), token.getCharacteristic(CharacteristicName.color).get());
        assertEquals(EnumSet.of(Type.artifact), token.getCharacteristic(CharacteristicName.cardType).get());
        assertEquals(List.of(ArtifactType.treasure), token.getCharacteristic(CharacteristicName.subtype).get());
        assertEquals("Treasure", token.getCharacteristic(CharacteristicName.name).get());
        // TODO: {T}, sac: add any
    }

    @Test
    void food() {
        token = PredefinedToken.create("Food");
        assertNotNull(token);
        assertTrue(token.getCharacteristic(CharacteristicName.color).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.cardType).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.subtype).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.name).isPresent());
        assertEquals(EnumSet.noneOf(Color.class), token.getCharacteristic(CharacteristicName.color).get());
        assertEquals(EnumSet.of(Type.artifact), token.getCharacteristic(CharacteristicName.cardType).get());
        assertEquals(List.of(ArtifactType.food), token.getCharacteristic(CharacteristicName.subtype).get());
        assertEquals("Food", token.getCharacteristic(CharacteristicName.name).get());
        // TODO: {2}, sac: gain 3
    }

    @Test
    void gold() {
        token = PredefinedToken.create("Gold");
        assertNotNull(token);
        assertTrue(token.getCharacteristic(CharacteristicName.color).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.cardType).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.subtype).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.name).isPresent());
        assertEquals(EnumSet.noneOf(Color.class), token.getCharacteristic(CharacteristicName.color).get());
        assertEquals(EnumSet.of(Type.artifact), token.getCharacteristic(CharacteristicName.cardType).get());
        assertEquals(List.of(ArtifactType.gold), token.getCharacteristic(CharacteristicName.subtype).get());
        assertEquals("Gold", token.getCharacteristic(CharacteristicName.name).get());
        // TODO: sac: add any
    }

    @Test
    void walker() {
        token = PredefinedToken.create("Walker");
        assertNotNull(token);
        assertTrue(token.getCharacteristic(CharacteristicName.powerToughness).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.color).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.cardType).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.subtype).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.name).isPresent());
        assertArrayEquals(new int[]{2, 2}, (int[]) token.getCharacteristic(CharacteristicName.powerToughness).get());
        assertEquals(EnumSet.of(Color.black), token.getCharacteristic(CharacteristicName.color).get());
        assertEquals(EnumSet.of(Type.creature), token.getCharacteristic(CharacteristicName.cardType).get());
        assertEquals(List.of(CreatureType.zombie), token.getCharacteristic(CharacteristicName.subtype).get());
        assertEquals("Walker", token.getCharacteristic(CharacteristicName.name).get());
    }

    @Test
    void shard() {
        token = PredefinedToken.create("Shard");
        assertNotNull(token);
        assertTrue(token.getCharacteristic(CharacteristicName.color).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.cardType).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.subtype).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.name).isPresent());
        assertEquals(EnumSet.noneOf(Color.class), token.getCharacteristic(CharacteristicName.color).get());
        assertEquals(EnumSet.of(Type.enchantment), token.getCharacteristic(CharacteristicName.cardType).get());
        assertEquals(List.of(EnchantmentType.shard), token.getCharacteristic(CharacteristicName.subtype).get());
        assertEquals("Shard", token.getCharacteristic(CharacteristicName.name).get());
        // TODO: {2}, sac: opt
    }

    @Test
    void clue() {
        token = PredefinedToken.create("Clue");
        assertNotNull(token);
        assertTrue(token.getCharacteristic(CharacteristicName.color).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.cardType).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.subtype).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.name).isPresent());
        assertEquals(EnumSet.noneOf(Color.class), token.getCharacteristic(CharacteristicName.color).get());
        assertEquals(EnumSet.of(Type.artifact), token.getCharacteristic(CharacteristicName.cardType).get());
        assertEquals(List.of(ArtifactType.clue), token.getCharacteristic(CharacteristicName.subtype).get());
        assertEquals("Clue", token.getCharacteristic(CharacteristicName.name).get());
        // TODO: {2}, sac: draw
    }
}
