package tegenton.card.game.concepts.token;

import org.junit.jupiter.api.Test;
import tegenton.card.game.concepts.Color;
import tegenton.card.game.type.Type;
import tegenton.card.game.type.subtype.ArtifactType;
import tegenton.card.game.type.subtype.CreatureType;
import tegenton.card.game.type.subtype.EnchantmentType;

import java.util.ArrayList;
import java.util.Collections;
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
        assertTrue(token.getColor().isPresent());
        assertTrue(token.getCardTypes().isPresent());
        assertTrue(token.getSubtypes().isPresent());
        assertTrue(token.getName().isPresent());
        assertIterableEquals(new ArrayList<>(), token.getColor().get());
        assertIterableEquals(List.of(Type.artifact), token.getCardTypes().get());
        assertIterableEquals(List.of(ArtifactType.treasure), token.getSubtypes().get());
        assertIterableEquals(new ArrayList<>(Collections.singleton("Treasure")), token.getName().get());
        // TODO: {T}, sac: add any
    }

    @Test
    void food() {
        token = PredefinedToken.create("Food");
        assertNotNull(token);
        assertTrue(token.getColor().isPresent());
        assertTrue(token.getCardTypes().isPresent());
        assertTrue(token.getSubtypes().isPresent());
        assertTrue(token.getName().isPresent());
        assertIterableEquals(new ArrayList<>(), token.getColor().get());
        assertIterableEquals(List.of(Type.artifact), token.getCardTypes().get());
        assertIterableEquals(List.of(ArtifactType.food), token.getSubtypes().get());
        assertIterableEquals(new ArrayList<>(Collections.singleton("Food")), token.getName().get());
        // TODO: {2}, sac: gain 3
    }

    @Test
    void gold() {
        token = PredefinedToken.create("Gold");
        assertNotNull(token);
        assertTrue(token.getColor().isPresent());
        assertTrue(token.getCardTypes().isPresent());
        assertTrue(token.getSubtypes().isPresent());
        assertTrue(token.getName().isPresent());
        assertIterableEquals(new ArrayList<>(), token.getColor().get());
        assertIterableEquals(List.of(Type.artifact), token.getCardTypes().get());
        assertIterableEquals(List.of(ArtifactType.gold), token.getSubtypes().get());
        assertIterableEquals(new ArrayList<>(Collections.singleton("Gold")), token.getName().get());
        // TODO: sac: add any
    }

    @Test
    void walker() {
        token = PredefinedToken.create("Walker");
        assertNotNull(token);
        assertTrue(token.getPower().isPresent());
        assertTrue(token.getToughness().isPresent());
        assertTrue(token.getColor().isPresent());
        assertTrue(token.getCardTypes().isPresent());
        assertTrue(token.getSubtypes().isPresent());
        assertTrue(token.getName().isPresent());
        assertEquals(2, token.getPower().get());
        assertEquals(2, token.getToughness().get());
        assertIterableEquals(List.of(Color.black), token.getColor().get());
        assertIterableEquals(List.of(Type.creature), token.getCardTypes().get());
        assertIterableEquals(List.of(CreatureType.zombie), token.getSubtypes().get());
        assertIterableEquals(new ArrayList<>(Collections.singleton("Walker")), token.getName().get());
    }

    @Test
    void shard() {
        token = PredefinedToken.create("Shard");
        assertNotNull(token);
        assertTrue(token.getColor().isPresent());
        assertTrue(token.getCardTypes().isPresent());
        assertTrue(token.getSubtypes().isPresent());
        assertTrue(token.getName().isPresent());
        assertIterableEquals(new ArrayList<>(), token.getColor().get());
        assertIterableEquals(List.of(Type.enchantment), token.getCardTypes().get());
        assertIterableEquals(List.of(EnchantmentType.shard), token.getSubtypes().get());
        assertIterableEquals(new ArrayList<>(Collections.singleton("Shard")), token.getName().get());
        // TODO: {2}, sac: opt
    }

    @Test
    void clue() {
        token = PredefinedToken.create("Clue");
        assertNotNull(token);
        assertTrue(token.getColor().isPresent());
        assertTrue(token.getCardTypes().isPresent());
        assertTrue(token.getSubtypes().isPresent());
        assertTrue(token.getName().isPresent());
        assertIterableEquals(new ArrayList<>(), token.getColor().get());
        assertIterableEquals(List.of(Type.artifact), token.getCardTypes().get());
        assertIterableEquals(List.of(ArtifactType.clue), token.getSubtypes().get());
        assertIterableEquals(new ArrayList<>(Collections.singleton("Clue")), token.getName().get());
        // TODO: {2}, sac: draw
    }

    @Test
    void invalid() {
        token = PredefinedToken.create("Some Dude");
        assertNull(token);
    }
}
