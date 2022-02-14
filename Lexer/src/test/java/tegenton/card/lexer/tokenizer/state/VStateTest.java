package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.target.object.ObjectAttribute;
import tegenton.card.lexicon.game.type.CounterType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VStateTest {
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
    void value() {
        input = "VALUE";
        expected = ObjectAttribute.VALUE;
    }

    @Test
    void vigilance() {
        input = "VIGILANCE";
        expected = Keyword.VIGILANCE;
    }

    @Test
    void vitality() {
        input = "VITALITY";
        expected = CounterType.VITALITY;
    }
}
