package tegenton.card.parser.node.object;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.source.target.object.ObjectAttribute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacteristicNodeTest {
    public static List<Word> tokens;
    public static CharacteristicNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        CharacteristicNode actual = new CharacteristicNode(tokens);
        assertEquals(expected, actual);
        assertEquals(0, tokens.size());
    }

    @Test
    void power() {
        Collections.addAll(tokens, ObjectAttribute.POWER);
        expected = new CharacteristicNode(ObjectAttribute.POWER);
    }

    @Test
    void toughness() {
        Collections.addAll(tokens, ObjectAttribute.TOUGHNESS);
        expected = new CharacteristicNode(ObjectAttribute.TOUGHNESS);
    }

    @Test
    void manaValue() {
        Collections.addAll(tokens, GameNoun.MANA, Symbol.SPACE, ObjectAttribute.VALUE);
        expected = new CharacteristicNode(ObjectAttribute.VALUE);
    }

    @Test
    void loyalty() {
        Collections.addAll(tokens, ObjectAttribute.LOYALTY);
        expected = new CharacteristicNode(ObjectAttribute.LOYALTY);
    }
}
