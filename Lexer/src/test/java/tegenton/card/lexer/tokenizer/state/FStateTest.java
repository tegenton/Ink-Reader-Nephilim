package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameVerb;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.target.object.ObjectAttribute;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.type.LandType;
import tegenton.card.lexicon.value.EnglishNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FStateTest {
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
    void face() {
        input = "FACE";
        expected = ObjectAttribute.FACE;
    }

    @Test
    void fear() {
        input = "FEAR";
        expected = Keyword.FEAR;
    }

    @Test
    void fewest() {
        input = "FEWEST";
        expected = Noun.FEWEST;
    }

    @Test
    void fifteen() {
        input = "FIFTEEN";
        expected = EnglishNumber.FIFTEEN;
    }

    @Test
    void finish() {
        input = "FINISH";
        expected = GameVerb.FINISH;
    }

    @Test
    void first() {
        input = "FIRST";
        expected = Adjective.FIRST;
    }

    @Test
    void five() {
        input = "FIVE";
        expected = EnglishNumber.FIVE;
    }

    @Test
    void flip() {
        input = "FLIP";
        expected = PlayerVerb.FLIP;
    }

    @Test
    void flying() {
        input = "FLYING";
        expected = Keyword.FLYING;
    }

    @Test
    void forTest() {
        input = "FOR";
        expected = Preposition.FOR;
    }

    @Test
    void foot() {
        input = "FOOT";
        expected = Noun.FOOT;
    }

    @Test
    void forest() {
        input = "FOREST";
        expected = LandType.FOREST;
    }

    @Test
    void four() {
        input = "FOUR";
        expected = EnglishNumber.FOUR;
    }

    @Test
    void from() {
        input = "FROM";
        expected = Preposition.FROM;
    }

}
