package tegenton.card.parser.node.phrase.headword;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.type.LandType;
import tegenton.card.lexicon.game.type.SuperType;
import tegenton.card.parser.ParseError;
import tegenton.card.parser.node.atom.AtomicObjectNode;
import tegenton.card.parser.node.atom.ConjunctionNode;
import tegenton.card.parser.node.atom.TypeNode;
import tegenton.card.parser.node.modifier.PremodifierNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ObjectNodeTest {
    public static List<Word> tokens;
    public static ObjectNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        try {
            assertEquals(expected, new ObjectNode(tokens));
        } catch (ParseError e) {
            System.err.println("Message:" + e.getMessage());
            System.err.println("Remaining tokens: " + e.getTokens());
            fail();
        }
        assertEquals(0, tokens.size());
    }

    @Test
    void basicForestOrPlains() {
        tokens.addAll(List.of(SuperType.BASIC, Symbol.SPACE, LandType.FOREST,
                Symbol.SPACE, Conjunction.OR, Symbol.SPACE, LandType.PLAINS));
        expected = new ObjectNode(
                new PremodifierNode(new TypeNode(SuperType.BASIC)),
                new AtomicObjectNode(new TypeNode(LandType.FOREST)),
                new ConjunctionNode(Conjunction.OR),
                new AtomicObjectNode(new TypeNode(LandType.PLAINS)));
    }
}
