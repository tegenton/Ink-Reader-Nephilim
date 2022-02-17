package tegenton.card.parser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.value.DigitNumber;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatModNodeTest {
    public static List<Word> tokens;
    public static StatModNode expected;

    @AfterEach
    void compare() {
        assertEquals(expected, new StatModNode(tokens));
    }

    @Test
    void plusOnePlusOne() {
        tokens = List.of(Symbol.PLUS, new DigitNumber(1), Symbol.SLASH,
                Symbol.PLUS, new DigitNumber(1));
        expected = new StatModNode(Symbol.PLUS, new DigitNumber(1), Symbol.PLUS,
                new DigitNumber(1));
    }

    @Test
    void plusZeroPlusTwo() {
        tokens = List.of(Symbol.PLUS, new DigitNumber(0), Symbol.SLASH,
                Symbol.PLUS, new DigitNumber(2));
        expected = new StatModNode(Symbol.PLUS, new DigitNumber(0), Symbol.PLUS,
                new DigitNumber(2));
    }

    @Test
    void minusTwoMinusOne() {
        tokens = List.of(Symbol.HYPHEN, new DigitNumber(2), Symbol.SLASH,
                Symbol.HYPHEN, new DigitNumber(1));
        expected = new StatModNode(Symbol.HYPHEN, new DigitNumber(2),
                Symbol.HYPHEN, new DigitNumber(1));
    }
}
