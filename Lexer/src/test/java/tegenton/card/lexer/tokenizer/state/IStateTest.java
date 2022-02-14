package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.game.type.CreatureType;
import tegenton.card.lexicon.game.type.LandType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IStateTest {
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
    void ifTest() {
        input = "IF";
        expected = SubordinateConjunction.IF;
    }

    @Test
    void ignore() {
        input = "IGNORE";
        expected = PlayerVerb.IGNORE;
    }

    @Test
    void in() {
        input = "IN";
        expected = Preposition.IN;
    }

    @Test
    void indestructible() {
        input = "INDESTRUCTIBLE";
        expected = Keyword.INDESTRUCTIBLE;
    }

    @Test
    void ing() {
        input = "ING";
        expected = Morpheme.ING;
    }

    @Test
    void insect() {
        input = "INSECT";
        expected = CreatureType.INSECT;
    }

    @Test
    void instance() {
        input = "INSTANCE";
        expected = Noun.INSTANCE;
    }

    @Test
    void instant() {
        input = "INSTANT";
        expected = CardType.INSTANT;
    }

    @Test
    void instead() {
        input = "INSTEAD";
        expected = Adverb.INSTEAD;
    }

    @Test
    void is() {
        input = "IS";
        expected = ObjectVerb.IS;
    }

    @Test
    void island() {
        input = "ISLAND";
        expected = LandType.ISLAND;
    }

    @Test
    void it() {
        input = "IT";
        expected = ObjectNoun.IT;
    }

}
