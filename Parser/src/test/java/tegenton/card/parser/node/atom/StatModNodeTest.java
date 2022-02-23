package tegenton.card.parser.node.atom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.value.DigitNumber;
import tegenton.card.parser.ParseError;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StatModNodeTest {
    public static List<Word> tokens;
    public static StatModNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        try {
            assertEquals(expected, new StatModNode(tokens));
        } catch (ParseError e) {
            System.err.println("Message:" + e.getMessage());
            System.err.println("Remaining tokens: " + e.getTokens());
            fail();
        }
        assertEquals(0, tokens.size());
    }

    @Test
    void plusOnePlusOne() {
        tokens.addAll(List.of(Symbol.PLUS, new DigitNumber(1), Symbol.SLASH,
                Symbol.PLUS, new DigitNumber(1)));
        expected = new StatModNode(Symbol.PLUS, new DigitNumber(1), Symbol.PLUS,
                new DigitNumber(1));
    }

    @Test
    void plusZeroPlusTwo() {
        tokens.addAll(List.of(Symbol.PLUS, new DigitNumber(0), Symbol.SLASH,
                Symbol.PLUS, new DigitNumber(2)));
        expected = new StatModNode(Symbol.PLUS, new DigitNumber(0), Symbol.PLUS,
                new DigitNumber(2));
    }

    @Test
    void minusTwoMinusOne() {
        tokens.addAll(List.of(Symbol.HYPHEN, new DigitNumber(2), Symbol.SLASH,
                Symbol.HYPHEN, new DigitNumber(1)));
        expected = new StatModNode(Symbol.HYPHEN, new DigitNumber(2),
                Symbol.HYPHEN, new DigitNumber(1));
    }
}
