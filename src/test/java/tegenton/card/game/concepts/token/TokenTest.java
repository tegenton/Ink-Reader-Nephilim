package tegenton.card.game.concepts.token;

import org.junit.jupiter.api.Test;
import tegenton.card.game.concepts.Color;
import tegenton.card.game.type.SuperType;
import tegenton.card.game.type.Type;
import tegenton.card.game.type.subtype.CreatureType;

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
        assertTrue(token.getPower().isPresent());
        assertTrue(token.getToughness().isPresent());
        assertTrue(token.getColor().isPresent());
        assertTrue(token.getCardTypes().isPresent());
        assertTrue(token.getSubtypes().isPresent());
        assertTrue(token.getName().isPresent());
        assertEquals(1, token.getPower().get());
        assertEquals(1, token.getToughness().get());
        assertEquals(EnumSet.of(Color.green), token.getColor().get());
        assertEquals(EnumSet.of(Type.creature), token.getCardTypes().get());
        assertEquals(List.of(CreatureType.saproling), token.getSubtypes().get());
        assertEquals(new ArrayList<>(Collections.singleton("Saproling")), token.getName().get());

        // TODO: assertTrue(token.getManaCost().isEmpty());
        assertTrue(token.getSuperTypes().isEmpty());
        // TODO: assertTrue(token.getRulesText().isEmpty());
        // TODO: assertTrue(token.getAbilities().isEmpty());
    }

    @Test
    void goblinScout() {
        /* A “Goblin Scout creature token,” for example, is named “Goblin Scout” and has the
        creature subtypes Goblin and Scout */
        token = Token.create("Goblin Scout creature");
        assertTrue(token.getCardTypes().isPresent());
        assertTrue(token.getSubtypes().isPresent());
        assertTrue(token.getName().isPresent());
        assertEquals(EnumSet.of(Type.creature), token.getCardTypes().get());
        assertEquals(List.of(CreatureType.goblin, CreatureType.scout), token.getSubtypes().get());
        assertEquals(new ArrayList<>(Collections.singleton("Goblin Scout")), token.getName().get());
    }

    @Test
    void kaldra() {
        token = LegendaryToken.create("Kaldra, a legendary 4/4 colorless Avatar creature");
        assertNotNull(token);
        assertTrue(token.getPower().isPresent());
        assertTrue(token.getToughness().isPresent());
        assertTrue(token.getColor().isPresent());
        assertTrue(token.getSuperTypes().isPresent());
        assertTrue(token.getCardTypes().isPresent());
        assertTrue(token.getSubtypes().isPresent());
        assertTrue(token.getName().isPresent());
        assertEquals(4, token.getPower().get());
        assertEquals(4, token.getToughness().get());
        assertEquals(EnumSet.noneOf(Color.class), token.getColor().get());
        assertEquals(EnumSet.of(SuperType.legendary), token.getSuperTypes().get());
        assertEquals(EnumSet.of(Type.creature), token.getCardTypes().get());
        assertEquals(List.of(CreatureType.avatar), token.getSubtypes().get());
        assertEquals(List.of("Kaldra"), token.getName().get());
    }

    @Test
    void malformed() {
        token = LegendaryToken.create("Some Dude");
        assertNull(token);
    }
}
