package game.concepts.token;

import game.concepts.Color;
import game.concepts.object.characteristics.CharacteristicName;
import game.type.SuperType;
import game.type.Type;
import game.type.subtype.CreatureType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TokenTest {
    public static Token token;

    @Test
    void jadeMage() {
        /*Example: Jade Mage has the ability “{2}{G}: Create a 1/1 green Saproling creature
        token.” The resulting token has no mana cost, supertypes, rules text, or abilities */
        token = Token.create("1/1 green Saproling creature");
        assertTrue(token.getCharacteristic(CharacteristicName.powerToughness).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.color).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.cardType).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.subtype).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.name).isPresent());
        assertArrayEquals(new int[]{1, 1}, (int[]) token.getCharacteristic(CharacteristicName.powerToughness).get());
        assertEquals(EnumSet.of(Color.green), token.getCharacteristic(CharacteristicName.color).get());
        assertEquals(EnumSet.of(Type.creature), token.getCharacteristic(CharacteristicName.cardType).get());
        assertEquals(List.of(CreatureType.saproling), token.getCharacteristic(CharacteristicName.subtype).get());
        assertEquals(new ArrayList<>(Collections.singleton("Saproling")), token.getCharacteristic(CharacteristicName.name).get());

        // TODO: assertTrue(token.getManaCost().isEmpty());
        assertTrue(token.getCharacteristic(CharacteristicName.superType).isEmpty());
        assertTrue(token.getCharacteristic(CharacteristicName.rulesText).isEmpty());
        // TODO: assertTrue(token.getAbilities().isEmpty());
    }

    @Test
    void goblinScout() {
        /* A “Goblin Scout creature token,” for example, is named “Goblin Scout” and has the
        creature subtypes Goblin and Scout */
        token = Token.create("Goblin Scout creature");
        assertTrue(token.getCharacteristic(CharacteristicName.cardType).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.subtype).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.name).isPresent());
        assertEquals(EnumSet.of(Type.creature), token.getCharacteristic(CharacteristicName.cardType).get());
        assertEquals(List.of(CreatureType.goblin, CreatureType.scout), token.getCharacteristic(CharacteristicName.subtype).get());
        assertEquals(new ArrayList<>(Collections.singleton("Goblin Scout")), token.getCharacteristic(CharacteristicName.name).get());
    }

    @Test
    void kaldra() {
        token = LegendaryToken.create("Kaldra, a legendary 4/4 colorless Avatar creature");
        assertNotNull(token);
        assertTrue(token.getCharacteristic(CharacteristicName.powerToughness).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.color).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.superType).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.cardType).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.subtype).isPresent());
        assertTrue(token.getCharacteristic(CharacteristicName.name).isPresent());
        assertArrayEquals(new int[]{4, 4}, (int[]) token.getCharacteristic(CharacteristicName.powerToughness).get());
        assertEquals(EnumSet.noneOf(Color.class), token.getCharacteristic(CharacteristicName.color).get());
        assertEquals(EnumSet.of(SuperType.legendary), token.getCharacteristic(CharacteristicName.superType).get());
        assertEquals(EnumSet.of(Type.creature), token.getCharacteristic(CharacteristicName.cardType).get());
        assertEquals(List.of(CreatureType.avatar), token.getCharacteristic(CharacteristicName.subtype).get());
        assertEquals(new ArrayList<>(Collections.singleton("Kaldra")), token.getCharacteristic(CharacteristicName.name).get());
    }
}
