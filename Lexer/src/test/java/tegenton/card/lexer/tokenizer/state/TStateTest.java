package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.*;
import tegenton.card.lexicon.game.Tap;
import tegenton.card.lexicon.game.target.TargetNoun;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.value.EnglishNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TStateTest {
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
    void t() {
        input = "T";
        expected = Tap.T;
    }

    @Test
    void take() {
        input = "TAKE";
        expected = PlayerVerb.TAKE;
    }

    @Test
    void tap() {
        input = "TAP";
        expected = ObjectVerb.TAP;
    }

    @Test
    void target() {
        input = "TARGET";
        expected = Determiner.TARGET;
    }

    @Test
    void ten() {
        input = "TEN";
        expected = EnglishNumber.TEN;
    }

    @Test
    void text() {
        input = "TEXT";
        expected = Noun.TEXT;
    }

    @Test
    void than() {
        input = "THAN";
        expected = Comparative.THAN;
    }

    @Test
    void that() {
        input = "THAT";
        expected = Determiner.THAT;
    }

    @Test
    void the() {
        input = "THE";
        expected = Determiner.THE;
    }

    @Test
    void their() {
        input = "THEIR";
        expected = TargetNoun.THEY;
    }

    @Test
    void them() {
        input = "THEM";
        expected = TargetNoun.THEM;
    }

    @Test
    void then() {
        input = "THEN";
        expected = Conjunction.THEN;
    }

    @Test
    void these() {
        input = "THESE";
        expected = Determiner.THESE;
    }

    @Test
    void they() {
        input = "THEY";
        expected = TargetNoun.THEY;
    }

    @Test
    void thirteen() {
        input = "THIRTEEN";
        expected = EnglishNumber.THIRTEEN;
    }

    @Test
    void this_() {
        input = "THIS";
        expected = Determiner.THIS;
    }

    @Test
    void those() {
        input = "THOSE";
        expected = Determiner.THOSE;
    }

    @Test
    void though() {
        input = "THOUGH";
        expected = SubordinateConjunction.THOUGH;
    }

    @Test
    void time() {
        input = "TIME";
        expected = Noun.TIME;
    }

    @Test
    void three() {
        input = "THREE";
        expected = EnglishNumber.THREE;
    }
}
