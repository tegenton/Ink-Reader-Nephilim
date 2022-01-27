package tegenton.card.parser.node;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectNoun;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;
import tegenton.card.lexicon.value.EnglishNumber;
import tegenton.card.parser.node.target.object.ObjectNode;
import tegenton.card.parser.node.target.player.PlayerNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerPhraseNodeTest {
    public static List<Word> tokens;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @Test
    void drawThreeCards() {
        Collections.addAll(tokens, Determiner.TARGET, Symbol.SPACE, PlayerVerb.PLAY, Morpheme.ER, Symbol.SPACE, PlayerVerb.DRAW, Symbol.SPACE, EnglishNumber.THREE, Symbol.SPACE, ObjectNoun.CARD, Morpheme.S);
        PlayerPhraseNode expected = new PlayerPhraseNode(new PlayerNode(PlayerVerb.PLAY, new DeterminerNode(Determiner.TARGET)), new PlayerVerbPhraseNode(PlayerVerb.DRAW, new ObjectNode(ObjectNoun.CARD, new ValueNode(EnglishNumber.THREE))));
        PlayerPhraseNode actual = new PlayerPhraseNode(tokens);
        assertEquals(expected, actual);
    }
}
