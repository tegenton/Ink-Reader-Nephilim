package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.target.object.ObjectAttribute;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.object.card.CardName;
import tegenton.card.lexicon.game.target.object.source.SourceVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.game.type.LandType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PStateTest {
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
    void pay() {
        input = "PAY";
        expected = PlayerVerb.PAY;
    }

    @Test
    void permanent() {
        input = "PERMANENT";
        expected = ObjectNoun.PERMANENT;
    }

    @Test
    void pile() {
        input = "PILE";
        expected = GameNoun.PILE;
    }

    @Test
    void power() {
        input = "POWER";
        expected = ObjectAttribute.POWER;
    }

    @Test
    void plague() {
        input = "PLAGUE";
        expected = CardName.PLAGUE;
    }

    @Test
    void plains() {
        input = "PLAINS";
        expected = LandType.PLAINS;
    }

    @Test
    void planeswalker() {
        input = "PLANESWALKER";
        expected = CardType.PLANESWALKER;
    }

    @Test
    void play() {
        input = "PLAY";
        expected = PlayerVerb.PLAY;
    }

    @Test
    void prevent() {
        input = "PREVENT";
        expected = PlayerVerb.PREVENT;
    }

    @Test
    void produce() {
        input = "PRODUCE";
        expected = SourceVerb.PRODUCE;
    }

    @Test
    void protection() {
        input = "PROTECTION";
        expected = Keyword.PROTECTION;
    }

    @Test
    void put() {
        input = "PUT";
        expected = PlayerVerb.PUT;
    }
}
