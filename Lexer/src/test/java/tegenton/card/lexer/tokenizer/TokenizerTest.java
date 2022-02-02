package tegenton.card.lexer.tokenizer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameVerb;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenizerTest {
    public static String input;
    public static Word expected;

    @AfterEach
    void compare() {
        assertEquals(expected, Tokenizer.tokenize(input));
    }

    @Test
    void a() {
        input = "A";
        expected = Determiner.A;
    }

    @Test
    void BE() {
        input = "BE";
        expected = GameVerb.BE;
    }
}
