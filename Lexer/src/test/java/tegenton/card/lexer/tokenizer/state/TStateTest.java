package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.value.EnglishNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TStateTest {
    @Test
    void target() {
        String input = "TARGET";
        Word expected = Determiner.TARGET;
        assertEquals(expected, new Tokenizer().tokenize(input).get(0));
    }

    @Test
    void three() {
        String input = "THREE";
        Word expected = EnglishNumber.THREE;
        assertEquals(expected, new Tokenizer().tokenize(input).get(0));
    }
}
