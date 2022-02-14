package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.lexicon.game.TriggerWord;
import tegenton.card.lexicon.game.target.TargetAuxiliaryVerb;
import tegenton.card.lexicon.game.target.TargetNoun;
import tegenton.card.lexicon.game.target.object.card.CardName;
import tegenton.card.lexicon.game.turn.Duration;
import tegenton.card.lexicon.game.type.CreatureType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WStateTest {
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
    void w() {
        input = "W";
        expected = ManaSymbol.W;
    }

    @Test
    void walk() {
        input = "WALK";
        expected = Keyword.WALK;
    }

    @Test
    void wall() {
        input = "WALL";
        expected = CreatureType.WALL;
    }

    @Test
    void wasp() {
        input = "WASP";
        expected = CardName.WASP;
    }

    @Test
    void way() {
        input = "WAY";
        expected = Noun.WAY;
    }

    @Test
    void when() {
        input = "WHEN";
        expected = TriggerWord.WHEN;
    }

    @Test
    void whenever() {
        input = "WHENEVER";
        expected = TriggerWord.WHENEVER;
    }

    @Test
    void where() {
        input = "WHERE";
        expected = SubordinateConjunction.WHERE;
    }

    @Test
    void whileTest() {
        input = "WHILE";
        expected = Duration.WHILE;
    }

    @Test
    void white() {
        input = "WHITE";
        expected = ColorWord.WHITE;
    }

    @Test
    void who() {
        input = "WHO";
        expected = TargetNoun.WHO;
    }

    @Test
    void with() {
        input = "WITH";
        expected = Preposition.WITH;
    }

    @Test
    void word() {
        input = "WORD";
        expected = Noun.WORD;
    }

    @Test
    void would() {
        input = "WOULD";
        expected = TargetAuxiliaryVerb.WOULD;
    }
}
