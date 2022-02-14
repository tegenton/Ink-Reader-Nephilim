package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.turn.Step;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.value.EnglishNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EStateTest {
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
    void each() {
        input = "EACH";
        expected = Determiner.EACH;
    }

    @Test
    void ed() {
        input = "ED";
        expected = Morpheme.ED;
    }

    @Test
    void effect() {
        input = "EFFECT";
        expected = GameNoun.EFFECT;
    }

    @Test
    void eight() {
        input = "EIGHT";
        expected = EnglishNumber.EIGHT;
    }

    @Test
    void eleven() {
        input = "ELEVEN";
        expected = EnglishNumber.ELEVEN;
    }

    @Test
    void enchant() {
        input = "ENCHANT";
        expected = Keyword.ENCHANT;
    }

    @Test
    void enchantment() {
        input = "ENCHANTMENT";
        expected = CardType.ENCHANTMENT;
    }

    @Test
    void end() {
        input = "END";
        expected = Step.END;
    }

    @Test
    void enter() {
        input = "ENTER";
        expected = ObjectVerb.ENTER;
    }

    @Test
    void equal() {
        input = "EQUAL";
        expected = Adjective.EQUAL;
    }

    @Test
    void er() {
        input = "ER";
        expected = Morpheme.ER;
    }

    @Test
    void evenly() {
        input = "EVENLY";
        expected = Adverb.EVENLY;
    }

    @Test
    void except() {
        input = "EXCEPT";
        expected = SubordinateConjunction.EXCEPT;
    }

    @Test
    void exchange() {
        input = "EXCHANGE";
        expected = PlayerVerb.EXCHANGE;
    }

    @Test
    void exile() {
        input = "EXILE";
        expected = Zone.EXILE;
    }

    @Test
    void extra() {
        input = "EXTRA";
        expected = Adjective.EXTRA;
    }

}
