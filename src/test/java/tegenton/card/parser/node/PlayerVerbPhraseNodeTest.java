package tegenton.card.parser.node;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectNoun;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;
import tegenton.card.lexicon.value.EnglishNumber;
import tegenton.card.parser.node.target.object.ObjectNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerVerbPhraseNodeTest {
    public static List<Word> tokens;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @Test
    void drawThreeCards() {
        Collections.addAll(tokens, PlayerVerb.DRAW, Symbol.SPACE, EnglishNumber.THREE, Symbol.SPACE, ObjectNoun.CARD, Morpheme.S);
        PlayerVerbPhraseNode expected = new PlayerVerbPhraseNode(PlayerVerb.DRAW, new ObjectNode(ObjectNoun.CARD, new ValueNode(EnglishNumber.THREE)));
        PlayerVerbPhraseNode actual = new PlayerVerbPhraseNode(tokens);
        assertEquals(expected, actual);
    }
}
