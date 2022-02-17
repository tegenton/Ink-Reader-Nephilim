package tegenton.card.parser.node.atom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjunctionNodeTest {
    public static List<Word> tokens;
    public static ConjunctionNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        assertEquals(expected, new ConjunctionNode(tokens));
        assertEquals(0, tokens.size());
    }

    @Test
    void and() {
        tokens.add(Conjunction.AND);
        expected = new ConjunctionNode(Conjunction.AND);
    }

    @Test
    void andOr() {
        tokens.addAll(List.of(Conjunction.AND, Symbol.SLASH, Conjunction.OR));
        expected = new ConjunctionNode(Conjunction.AND, Symbol.SLASH,
                Conjunction.OR);
    }

    @Test
    void or() {
        tokens.add(Conjunction.OR);
        expected = new ConjunctionNode(Conjunction.OR);
    }

    @Test
    void then() {
        tokens.add(Conjunction.THEN);
        expected = new ConjunctionNode(Conjunction.THEN);
    }
}
