package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.object.ObjectAttribute;
import tegenton.card.lexicon.value.EnglishNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NStateTest {
    public static String input;
    public static Word expected;
    public static Tokenizer tokenizer;

    @BeforeEach
    void setup() {
        tokenizer = new Tokenizer();
    }

    @AfterEach
    void compare() {
        assertEquals(expected, tokenizer.tokenize(input).get(0));
    }

    @Test
    void name() {
        input = "NAME";
        expected = ObjectAttribute.NAME;
    }

    @Test
    void newTest() {
        input = "NEW";
        expected = Adjective.NEW;
    }

    @Test
    void next() {
        input = "NEXT";
        expected = Adjective.NEXT;
    }

    @Test
    void nine() {
        input = "NINE";
        expected = EnglishNumber.NINE;
    }

    @Test
    void nineteen() {
        input = "NINETEEN";
        expected = EnglishNumber.NINETEEN;
    }

    @Test
    void not() {
        input = "NOT";
        expected = Adverb.NOT;
    }

    @Test
    void no() {
        input = "NO";
        expected = Determiner.NO;
    }

    @Test
    void number() {
        input = "NUMBER";
        expected = Noun.NUMBER;
    }
}
