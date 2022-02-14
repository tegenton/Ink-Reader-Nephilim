package tegenton.card.lexer.tokenizer.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Pronoun;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.object.source.SourceNoun;
import tegenton.card.lexicon.game.target.player.PlayerAttribute;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.turn.Duration;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.game.type.LandType;
import tegenton.card.lexicon.value.EnglishNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SStateTest {
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
    void s() {
        input = "S";
        expected = Morpheme.S;
    }

    @Test
    void sacrifice() {
        input = "SACRIFICE";
        expected = PlayerVerb.SACRIFICE;
    }

    @Test
    void same() {
        input = "SAME";
        expected = Adjective.SAME;
    }

    @Test
    void search() {
        input = "SEARCH";
        expected = PlayerVerb.SEARCH;
    }

    @Test
    void seven() {
        input = "SEVEN";
        expected = EnglishNumber.SEVEN;
    }

    @Test
    void seventeen() {
        input = "SEVENTEEN";
        expected = EnglishNumber.SEVENTEEN;
    }

    @Test
    void shuffle() {
        input = "SHUFFLE";
        expected = PlayerVerb.SHUFFLE;
    }

    @Test
    void since() {
        input = "SINCE";
        expected = Duration.SINCE;
    }

    @Test
    void six() {
        input = "SIX";
        expected = EnglishNumber.SIX;
    }

    @Test
    void sixteen() {
        input = "SIXTEEN";
        expected = EnglishNumber.SIXTEEN;
    }

    @Test
    void size() {
        input = "SIZE";
        expected = PlayerAttribute.SIZE;
    }

    @Test
    void skip() {
        input = "SKIP";
        expected = PlayerVerb.SKIP;
    }

    @Test
    void spell() {
        input = "SPELL";
        expected = ObjectNoun.SPELL;
    }

    @Test
    void spend() {
        input = "SPEND";
        expected = PlayerVerb.SPEND;
    }

    @Test
    void so() {
        input = "SO";
        expected = Pronoun.SO;
    }

    @Test
    void some() {
        input = "SOME";
        expected = Determiner.SOME;
    }

    @Test
    void sorcery() {
        input = "SORCERY";
        expected = CardType.SORCERY;
    }

    @Test
    void source() {
        input = "SOURCE";
        expected = SourceNoun.SOURCE;
    }

    @Test
    void still() {
        input = "STILL";
        expected = Adverb.STILL;
    }

    @Test
    void strike() {
        input = "STRIKE";
        expected = Keyword.STRIKE;
    }

    @Test
    void swamp() {
        input = "SWAMP";
        expected = LandType.SWAMP;
    }
}
