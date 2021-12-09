package tegenton.card.parse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tegenton.card.parse.lexicon.Word;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LexerTest {
    public static Lexer lex;

    @BeforeEach
    void setup() {
        lex = new Lexer();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "one", "flying", "draw", "1", ".", "any", "when"})
    void singleWord(String text) {
        List<Word> tokens = Stream.of(text).collect(lex).toList();
        StringBuilder s = new StringBuilder();
        for (Word token : tokens) {
            s.append(token.getWord());
        }
        assertEquals(text.toLowerCase(), s.toString().toLowerCase());
    }
}
