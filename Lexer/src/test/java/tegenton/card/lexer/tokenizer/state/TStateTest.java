package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Tap;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.value.EnglishNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TStateTest {
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
    void t() {
        input = "T";
        expected = Tap.T;
    }

    @Test
    void take() {
        input = "TAKE";
        expected = PlayerVerb.TAKE;
    }

    @Test
    void tap() {
        input = "TAP";
        expected = ObjectVerb.TAP;
    }

    @Test
    void target() {
        input = "TARGET";
        expected = Determiner.TARGET;
    }

    @Test
    void ten() {
        input = "TEN";
        expected = EnglishNumber.TEN;
    }

    @Test
    void text() {
        input = "TEXT";
        expected = Noun.TEXT;
    }

    @Test
    void three() {
        input = "THREE";
        expected = EnglishNumber.THREE;
    }
}
