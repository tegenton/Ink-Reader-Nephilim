package tegenton.card.parser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjunctionNodeTest {
    public static List<Word> tokens;
    public static ConjunctionNode expected;

    @AfterEach
    void compare() {
        assertEquals(expected, new ConjunctionNode(tokens));
    }

    @Test
    void and() {
        tokens = List.of(Conjunction.AND);
        expected = new ConjunctionNode(Conjunction.AND);
    }

    @Test
    void andOr() {
        tokens = List.of(Conjunction.AND, Symbol.SLASH, Conjunction.OR);
        expected = new ConjunctionNode(Conjunction.AND, Symbol.SLASH,
                Conjunction.OR);
    }

    @Test
    void or() {
        tokens = List.of(Conjunction.OR);
        expected = new ConjunctionNode(Conjunction.OR);
    }

    @Test
    void then() {
        tokens = List.of(Conjunction.THEN);
        expected = new ConjunctionNode(Conjunction.THEN);
    }
}
