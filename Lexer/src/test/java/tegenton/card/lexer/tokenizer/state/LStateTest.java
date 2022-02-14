package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Particle;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.target.TargetVerb;
import tegenton.card.lexicon.game.target.object.ObjectAttribute;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.type.CardType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LStateTest {
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
    void label() {
        input = "LABEL";
        expected = Noun.LABEL;
    }

    @Test
    void land() {
        input = "LAND";
        expected = CardType.LAND;
    }

    @Test
    void least() {
        input = "LEAST";
        expected = Determiner.LEAST;
    }

    @Test
    void leave() {
        input = "LEAVE";
        expected = ObjectVerb.LEAVE;
    }

    @Test
    void left() {
        input = "LEFT";
        expected = Particle.LEFT;
    }

    @Test
    void less() {
        input = "LESS";
        expected = Comparative.LESS;
    }

    @Test
    void library() {
        input = "LIBRARY";
        expected = Zone.LIBRARY;
    }

    @Test
    void life() {
        input = "LIFE";
        expected = GameNoun.LIFE;
    }

    @Test
    void likewise() {
        input = "LIKEWISE";
        expected = Adverb.LIKEWISE;
    }

    @Test
    void longTest() {
        input = "LONG";
        expected = SubordinateConjunction.LONG;
    }

    @Test
    void look() {
        input = "LOOK";
        expected = PlayerVerb.LOOK;
    }

    @Test
    void lose() {
        input = "LOSE";
        expected = TargetVerb.LOSE;
    }

    @Test
    void loyalty() {
        input = "LOYALTY";
        expected = ObjectAttribute.LOYALTY;
    }

}
