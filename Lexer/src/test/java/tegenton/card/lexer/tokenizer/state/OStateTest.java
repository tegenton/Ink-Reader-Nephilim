package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.player.PlayerNoun;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.value.EnglishNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OStateTest {
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
    void of() {
        input = "OF";
        expected = Preposition.OF;
    }

    @Test
    void once() {
        input = "ONCE";
        expected = Adverb.ONCE;
    }

    @Test
    void on() {
        input = "ON";
        expected = Preposition.ON;
    }

    @Test
    void one() {
        input = "ONE";
        expected = EnglishNumber.ONE;
    }

    @Test
    void only() {
        input = "ONLY";
        expected = Adverb.ONLY;
    }

    @Test
    void opponent() {
        input = "OPPONENT";
        expected = PlayerNoun.OPPONENT;
    }

    @Test
    void or() {
        input = "OR";
        expected = Conjunction.OR;
    }

    @Test
    void order() {
        input = "ORDER";
        expected = Noun.ORDER;
    }

    @Test
    void other() {
        input = "OTHER";
        expected = Determiner.OTHER;
    }

    @Test
    void out() {
        input = "OUT";
        expected = Preposition.OUT;
    }

    @Test
    void over() {
        input = "OVER";
        expected = Adverb.OVER;
    }

    @Test
    void own() {
        input = "OWN";
        expected = PlayerVerb.OWN;
    }
}
