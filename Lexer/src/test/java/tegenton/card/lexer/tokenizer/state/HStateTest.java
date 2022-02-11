package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Genitive;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.target.object.ObjectVerb;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HStateTest {
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
    void half() {
        input = "HALF";
        expected = Genitive.HALF;
    }

    @Test
    void hand() {
        input = "HAND";
        expected = Zone.HAND;
    }

    @Test
    void haste() {
        input = "HASTE";
        expected = Keyword.HASTE;
    }

    @Test
    void have() {
        input = "HAVE";
        expected = ObjectVerb.HAVE;
    }

    @Test
    void height() {
        input = "HEIGHT";
        expected = Noun.HEIGHT;
    }

}
