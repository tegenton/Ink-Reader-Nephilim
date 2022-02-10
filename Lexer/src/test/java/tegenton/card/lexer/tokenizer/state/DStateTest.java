package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Particle;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.target.object.source.SourceVerb;
import tegenton.card.lexicon.game.target.player.PlayerAdjective;
import tegenton.card.lexicon.game.target.player.PlayerVerb;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DStateTest {
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
    void damage() {
        input = "DAMAGE";
        expected = GameNoun.DAMAGE;
    }

    @Test
    void deal() {
        input = "DEAL";
        expected = SourceVerb.DEAL;
    }

    @Test
    void deck() {
        input = "DECK";
        expected = Zone.DECK;
    }

    @Test
    void declare() {
        input = "DECLARE";
        expected = PlayerVerb.DECLARE;
    }

    @Test
    void defender() {
        input = "DEFENDER";
        expected = Keyword.DEFENDER;
    }

    @Test
    void defending() {
        input = "DEFENDING";
        expected = PlayerAdjective.DEFENDING;
    }

    @Test
    void destroy() {
        input = "DESTROY";
        expected = PlayerVerb.DESTROY;
    }

    @Test
    @DisplayName("do")
    void wordDo() {
        input = "DO";
        expected = SourceVerb.DO;
    }

    @Test
    void down() {
        input = "DOWN";
        expected = Particle.DOWN;
    }
}
