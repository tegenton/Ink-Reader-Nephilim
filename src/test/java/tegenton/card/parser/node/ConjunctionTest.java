package tegenton.card.parser.node;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjunctionTest {
    public static List<Word> tokens;
    public static ConjunctionNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        ConjunctionNode actual = new ConjunctionNode(tokens);
        assertEquals(expected, actual);
        assertEquals(0, tokens.size());
    }

    @Test
    void and() {
        Collections.addAll(tokens, Conjunction.AND);
        expected = new ConjunctionNode(Conjunction.AND);
    }

    @Test
    void or() {
        Collections.addAll(tokens, Conjunction.OR);
        expected = new ConjunctionNode(Conjunction.OR);
    }

    @Test
    void andSlashOr() {
        Collections.addAll(tokens, Conjunction.AND, Symbol.SLASH, Conjunction.OR);
        expected = new ConjunctionNode(Symbol.SLASH);
    }

    @Test
    void then() {
        Collections.addAll(tokens, Conjunction.THEN);
        expected = new ConjunctionNode(Conjunction.THEN);
    }
}
