package tegenton.card.parser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectNoun;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;
import tegenton.card.lexicon.value.EnglishNumber;
import tegenton.card.parser.node.CardNode;
import tegenton.card.parser.node.ParseNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    public static ParseNode expected;
    public static List<Word> input;

    @BeforeEach
    void setup() {
        input = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        Parser parse = new Parser();
        ParseNode actual = parse.parse(input);
        assertEquals(expected, actual);
    }

    @Test
    void ancestralRecall() {
        expected = new CardNode(null);
        Collections.addAll(input, Determiner.TARGET, Symbol.SPACE, PlayerVerb.PLAY, Morpheme.ER, Symbol.SPACE, PlayerVerb.DRAW, Symbol.SPACE, EnglishNumber.THREE, Symbol.SPACE, ObjectNoun.CARD, Morpheme.S, Symbol.PERIOD);
    }
}
