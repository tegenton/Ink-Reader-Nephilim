package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameVerb;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.turn.Chronology;
import tegenton.card.lexicon.game.turn.Phase;
import tegenton.card.lexicon.game.type.SuperType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BStateTest {
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
    void b() {
        input = "B";
        expected = ManaSymbol.B;
    }

    @Test
    void back() {
        input = "BACK";
        expected = Adverb.BACK;
    }

    @Test
    void banding() {
        input = "BANDING";
        expected = Keyword.BANDING;
    }

    @Test
    void basic() {
        input = "BASIC";
        expected = SuperType.BASIC;
    }

    @Test
    void battlefield() {
        input = "BATTLEFIELD";
        expected = Zone.BATTLEFIELD;
    }

    @Test
    void become() {
        input = "BECOME";
        expected = ObjectVerb.BECOME;
    }

    @Test
    void been() {
        input = "BEEN";
        expected = GameVerb.BE;
    }

    @Test
    void before() {
        input = "BEFORE";
        expected = Chronology.BEFORE;
    }

    @Test
    void begin() {
        input = "BEGIN";
        expected = PlayerVerb.BEGIN;
    }

    @Test
    void beginning() {
        input = "BEGINNING";
        expected = Phase.BEGINNING;
    }

    @Test
    void beyond() {
        input = "BEYOND";
        expected = Preposition.BEYOND;
    }
}
