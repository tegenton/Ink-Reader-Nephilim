package tegenton.card.parse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import tegenton.card.parse.lexicon.Word;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public abstract class LexTestTemplate {
    public static String text;
    public static List<Word> tokens;

    @BeforeEach
    void setup() {
        text = null;
        tokens = null;
    }

    @AfterEach
    void lex() {
        Lexer lex = new Lexer();
        List<Word> words = lex.lex(text);
        if (tokens != null)
            assertIterableEquals(tokens, words);
    }
}
