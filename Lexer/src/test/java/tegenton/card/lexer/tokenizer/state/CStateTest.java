package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameVerb;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.lexicon.game.target.TargetAuxiliaryVerb;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.player.PlayerVerb;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CStateTest {
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
    void c() {
        input = "C";
        expected = ManaSymbol.C;
    }

    @Test
    void can() {
        input = "CAN";
        expected = TargetAuxiliaryVerb.CAN;
    }

    @Test
    void card() {
        input = "CARD";
        expected = ObjectNoun.CARD;
    }

    @Test
    void cast() {
        input = "CAST";
        expected = PlayerVerb.CAST;
    }

    @Test
    void cause() {
        input = "CAUSE";
        expected = GameVerb.CAUSE;
    }
}
