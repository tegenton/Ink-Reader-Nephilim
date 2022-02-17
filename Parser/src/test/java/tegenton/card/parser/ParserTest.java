package tegenton.card.parser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.value.EnglishNumber;
import tegenton.card.parser.node.CardNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    public static List<Word> tokens;
    public static CardNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        assertEquals(expected, Parser.parse(tokens));
    }

    @Test
    void empty() {
        // TODO
        expected = new CardNode(null);
    }

    @Test
    void ancestralRecall() {
        tokens.addAll(List.of(Determiner.TARGET, Symbol.SPACE, PlayerVerb.PLAY,
                Morpheme.ER, Symbol.SPACE, PlayerVerb.DRAW, Symbol.SPACE,
                EnglishNumber.THREE, Symbol.SPACE, ObjectNoun.CARD, Morpheme.S,
                Symbol.PERIOD));
        // TODO
        expected = new CardNode(null);
    }
}
