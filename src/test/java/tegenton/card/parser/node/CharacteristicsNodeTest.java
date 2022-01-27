package tegenton.card.parser.node;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectAttribute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacteristicsNodeTest {
    public static List<Word> tokens;
    public static CharacteristicsNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        CharacteristicsNode actual = new CharacteristicsNode(tokens);
        assertEquals(expected, actual);
        assertEquals(0, tokens.size());
    }

    @Test
    void powerAndToughness() {
        Collections.addAll(tokens, ObjectAttribute.POWER, Symbol.SPACE, Conjunction.AND, Symbol.SPACE, ObjectAttribute.TOUGHNESS);
        expected = new CharacteristicsNode(new CharacteristicNode(ObjectAttribute.POWER), new ConjunctionNode(Conjunction.AND), new CharacteristicNode(ObjectAttribute.TOUGHNESS));
    }
}
