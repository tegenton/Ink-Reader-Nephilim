package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.target.TargetVerb;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.type.CreatureType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GStateTest {
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
    void g() {
        input = "G";
        expected = ManaSymbol.G;
    }

    @Test
    void gain() {
        input = "GAIN";
        expected = TargetVerb.GAIN;
    }

    @Test
    void game() {
        input = "GAME";
        expected = GameNoun.GAME;
    }

    @Test
    void get() {
        input = "GET";
        expected = ObjectVerb.GET;
    }

    @Test
    void goblin() {
        input = "GOBLIN";
        expected = CreatureType.GOBLIN;
    }

    @Test
    void golem() {
        input = "GOLEM";
        expected = CreatureType.GOLEM;
    }

    @Test
    void graveyard() {
        input = "GRAVEYARD";
        expected = Zone.GRAVEYARD;
    }

    @Test
    void greater() {
        input = "GREATER";
        expected = Comparative.GREATER;
    }

    @Test
    void green() {
        input = "GREEN";
        expected = ColorWord.GREEN;
    }

}
