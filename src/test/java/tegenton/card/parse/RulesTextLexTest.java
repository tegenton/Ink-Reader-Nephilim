package tegenton.card.parse;

import org.junit.jupiter.api.AfterEach;
import tegenton.card.parse.lexicon.Word;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class RulesTextLexTest extends RulesTextTestCase {
    @AfterEach
    void lex() {
        Lexer lex = new Lexer();
        List<Word> words = lex.lex(text);
        if (tokens != null)
            assertIterableEquals(tokens, words);
    }
}
