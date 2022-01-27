package tegenton.card.parser.node.type;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.parser.node.ConjunctionNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypesNodeTest {
    public static List<Word> tokens;
    public static TypesNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        TypesNode actual = new TypesNode(tokens);
        assertEquals(expected, actual);
        assertEquals(0, tokens.size());
    }

    @Test
    void artifactCreatureOrLand() {
        Collections.addAll(tokens, CardType.ARTIFACT, Symbol.COMMA, Symbol.SPACE, CardType.CREATURE, Symbol.COMMA, Symbol.SPACE, Conjunction.OR, Symbol.SPACE, CardType.LAND);
        expected = new TypesNode(new ConjunctionNode(Conjunction.OR), new TypeNode(CardType.ARTIFACT), new TypeNode(CardType.CREATURE), new TypeNode(CardType.LAND));
    }

    @Test
    void artifactOrEnchantment() {
        Collections.addAll(tokens, CardType.ARTIFACT, Symbol.SPACE, Conjunction.OR, Symbol.SPACE, CardType.ENCHANTMENT);
        expected = new TypesNode(new ConjunctionNode(Conjunction.OR), new TypeNode(CardType.ARTIFACT), new TypeNode(CardType.ENCHANTMENT));
    }
}
