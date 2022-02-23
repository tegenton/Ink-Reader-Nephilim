package tegenton.card.parser.node.modifier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.ParseError;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class AmountNodeTest {
    public static List<Word> tokens;
    public static AmountNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        try {
            assertEquals(expected, new AmountNode(tokens));
        } catch (ParseError e) {
            System.err.println("Message:" + e.getMessage());
            System.err.println("Remaining tokens: " + e.getTokens());
            fail();
        }
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
