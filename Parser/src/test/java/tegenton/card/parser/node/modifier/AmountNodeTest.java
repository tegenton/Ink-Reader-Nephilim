package tegenton.card.parser.node.modifier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AmountNodeTest {
    public static List<Word> tokens;
    public static AmountNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        assertEquals(expected, new AmountNode(tokens));
        assertEquals(0, tokens.size());
    }

    @Test
    void aNumberOf() {
        tokens.addAll(
                List.of(Determiner.A, Symbol.SPACE, Noun.NUMBER, Symbol.SPACE,
                        Preposition.OF));
        expected = new AmountNode(Determiner.A, Noun.NUMBER, Preposition.OF);
    }
}
