package tegenton.card.lexer.tokenizer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameVerb;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenizerTest {
    public static String input;
    public static List<Word> expected;

    @AfterEach
    void compare() {
        Tokenizer tokenizer = new Tokenizer();
        assertEquals(expected, tokenizer.tokenize(input));
    }

    @Test
    void a() {
        input = "A";
        expected = List.of(Determiner.A);
    }

    @Test
    void BE() {
        input = "BE";
        expected = List.of(GameVerb.BE);
    }
}
