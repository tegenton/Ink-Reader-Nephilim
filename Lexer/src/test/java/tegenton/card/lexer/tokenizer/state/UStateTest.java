package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Particle;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.lexicon.game.turn.Duration;
import tegenton.card.lexicon.game.turn.Step;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UStateTest {
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
    void u() {
        input = "U";
        expected = ManaSymbol.U;
    }

    @Test
    void under() {
        input = "UNDER";
        expected = Preposition.UNDER;
    }

    @Test
    void unless() {
        input = "UNLESS";
        expected = Conjunction.UNLESS;
    }

    @Test
    void until() {
        input = "UNTIL";
        expected = Duration.UNTIL;
    }

    @Test
    void up() {
        input = "UP";
        expected = Particle.UP;
    }

    @Test
    void upkeep() {
        input = "UPKEEP";
        expected = Step.UPKEEP;
    }
}
