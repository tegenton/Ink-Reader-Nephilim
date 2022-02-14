package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.target.player.PlayerAttribute;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.turn.Phase;
import tegenton.card.lexicon.game.type.CounterType;
import tegenton.card.lexicon.game.type.CreatureType;
import tegenton.card.lexicon.game.type.LandType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MStateTest {
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
    void main() {
        input = "MAIN";
        expected = Phase.MAIN;
    }

    @Test
    void mana() {
        input = "MANA";
        expected = GameNoun.MANA;
    }

    @Test
    void many() {
        input = "MANY";
        expected = Determiner.MANY;
    }

    @Test
    void maximum() {
        input = "MAXIMUM";
        expected = PlayerAttribute.MAXIMUM;
    }

    @Test
    void may() {
        input = "MAY";
        expected = PlayerVerb.MAY;
    }

    @Test
    void merfolk() {
        input = "MERFOLK";
        expected = CreatureType.MERFOLK;
    }

    @Test
    void minus() {
        input = "MINUS";
        expected = Preposition.MINUS;
    }

    @Test
    void mire() {
        input = "MIRE";
        expected = CounterType.MIRE;
    }

    @Test
    void more() {
        input = "MORE";
        expected = Comparative.MORE;
    }

    @Test
    void mountain() {
        input = "MOUNTAIN";
        expected = LandType.MOUNTAIN;
    }

}
