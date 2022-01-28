package tegenton.card.parser.node.ability.target.object;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectNoun;
import tegenton.card.lexicon.value.EnglishNumber;
import tegenton.card.parser.node.ValueNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectNodeTest {
    public static List<Word> tokens;
    public static ObjectNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        ObjectNode actual = new ObjectNode(tokens);
        assertEquals(expected, actual);
        assertEquals(0, tokens.size());
    }

    @Test
    void threeCards() {
        Collections.addAll(tokens, EnglishNumber.THREE, Symbol.SPACE, ObjectNoun.CARD, Morpheme.S);
        expected = new ObjectNode(ObjectNoun.CARD, new ValueNode(EnglishNumber.THREE));
    }
}
