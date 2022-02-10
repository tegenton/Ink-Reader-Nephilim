package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.GameVerb;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.lexicon.game.target.TargetAuxiliaryVerb;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerAdverb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.turn.Phase;
import tegenton.card.lexicon.game.type.CounterType;

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

    @Test
    void change() {
        input = "CHANGE";
        expected = PlayerVerb.CHANGE;
    }

    @Test
    void choice() {
        input = "CHOICE";
        expected = Noun.CHOICE;
    }

    @Test
    void choose() {
        input = "CHOOSE";
        expected = PlayerVerb.CHOOSE;
    }

    @Test
    void chosen() {
        input = "CHOSEN";
        expected = Adjective.CHOSEN;
    }

    @Test
    void color() {
        input = "COLOR";
        expected = GameNoun.COLOR;
    }

    @Test
    void combat() {
        input = "COMBAT";
        expected = Phase.COMBAT;
    }

    @Test
    void completely() {
        input = "COMPLETELY";
        expected = Adverb.COMPLETELY;
    }

    @Test
    void continuously() {
        input = "CONTINUOUSLY";
        expected = PlayerAdverb.CONTINUOUSLY;
    }

    @Test
    void control() {
        input = "CONTROL";
        expected = PlayerVerb.CONTROL;
    }

    @Test
    void copy() {
        input = "COPY";
        expected = ObjectNoun.COPY;
    }

    @Test
    void corpse() {
        input = "CORPSE";
        expected = CounterType.CORPSE;
    }

    @Test
    void cost() {
        input = "COST";
        expected = ObjectVerb.COST;
    }

    @Test
    void could() {
        input = "COULD";
        expected = PlayerVerb.COULD;
    }

    @Test
    void counter() {
        input = "COUNTER";
        expected = PlayerVerb.COUNTER;
    }
}
