package tegenton.card.parser.node.ability;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;
import tegenton.card.parser.node.ability.target.player.PlayerNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SubjectNodeTest {
    public static List<Word> input;
    public static SubjectNode expected;

    @BeforeEach
    void setup() {
        input = new ArrayList<>();
    }

    @Test
    void eachPlayer() {
        Collections.addAll(input, Determiner.EACH, Symbol.SPACE, PlayerVerb.PLAY, Morpheme.ER);
        expected = new SubjectNode(Determiner.EACH, new PlayerNode(PlayerVerb.PLAY));
    }
}
