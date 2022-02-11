package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Particle;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.lexicon.game.target.object.card.CardName;
import tegenton.card.lexicon.game.target.object.source.SourceVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RStateTest {
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
    void r() {
        input = "R";
        expected = ManaSymbol.R;
    }

    @Test
    void random() {
        input = "RANDOM";
        expected = Noun.RANDOM;
    }

    @Test
    void rats() {
        input = "RATS";
        expected = CardName.RATS;
    }

    @Test
    void reach() {
        input = "REACH";
        expected = Keyword.REACH;
    }

    @Test
    void red() {
        input = "RED";
        expected = ColorWord.RED;
    }

    @Test
    void regenerate() {
        input = "REGENERATE";
        expected = PlayerVerb.REGENERATE;
    }

    @Test
    void remove() {
        input = "REMOVE";
        expected = PlayerVerb.REMOVE;
    }

    @Test
    void replace() {
        input = "REPLACE";
        expected = PlayerVerb.REPLACE;
    }

    @Test
    void resolve() {
        input = "RESOLVE";
        expected = SourceVerb.RESOLVE;
    }

    @Test
    void rest() {
        input = "REST";
        expected = Noun.REST;
    }

    @Test
    void returnTest() {
        input = "RETURN";
        expected = PlayerVerb.RETURN;
    }

    @Test
    void right() {
        input = "RIGHT";
        expected = Particle.RIGHT;
    }

    @Test
    void rounded() {
        input = "ROUNDED";
        expected = Adjective.ROUNDED;
    }


}
