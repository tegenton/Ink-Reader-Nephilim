package tegenton.card.parser.node.phrase;

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
import tegenton.card.parser.node.atom.AtomicObjectNode;
import tegenton.card.parser.node.atom.AtomicPlayerNode;
import tegenton.card.parser.node.atom.DeterminerNode;
import tegenton.card.parser.node.phrase.headword.ObjectNode;
import tegenton.card.parser.node.phrase.headword.PlayerNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerPhraseNodeTest {
    public static List<Word> tokens;
    public static PlayerPhraseNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        assertEquals(expected, new PlayerPhraseNode(tokens));
        assertEquals(0, tokens.size());
    }

    @Test
    void ancestralRecall() {
        tokens.addAll(List.of(Determiner.TARGET, Symbol.SPACE, PlayerVerb.PLAY,
                Morpheme.ER, Symbol.SPACE, PlayerVerb.DRAW, Symbol.SPACE,
                EnglishNumber.THREE, Symbol.SPACE, ObjectNoun.CARD,
                Morpheme.S));
        expected = new PlayerPhraseNode(
                new PlayerNode(new DeterminerNode(Determiner.TARGET),
                        new AtomicPlayerNode(PlayerVerb.PLAY, Morpheme.ER)),
                new PlayerVerbPhraseNode(PlayerVerb.DRAW,
                        new ObjectNode(new DeterminerNode(EnglishNumber.THREE),
                                new AtomicObjectNode(ObjectNoun.CARD,
                                        Morpheme.S))));
    }
}
