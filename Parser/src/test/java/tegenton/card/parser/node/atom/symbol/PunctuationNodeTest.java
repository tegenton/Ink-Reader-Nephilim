package tegenton.card.parser.node.atom.symbol;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PunctuationNodeTest {
    public static List<Word> tokens;
    public static PunctuationNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        assertEquals(expected, new PunctuationNode(tokens));
        assertEquals(0, tokens.size());
    }

    @Test
    void comma() {
        tokens.add(Symbol.COMMA);
        expected = new PunctuationNode(Symbol.COMMA);
    }

    @Test
    void period() {
        tokens.add(Symbol.PERIOD);
        expected = new PunctuationNode(Symbol.PERIOD);
    }
}
