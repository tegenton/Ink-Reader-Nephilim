package tegenton.card.parser.node.atom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.TargetNoun;
import tegenton.card.lexicon.game.target.player.PlayerNoun;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.parser.ParseError;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtomicPlayerNodeTest {
    public static List<Word> tokens;
    public static AtomicPlayerNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() throws ParseError {
        assertEquals(expected, new AtomicPlayerNode(tokens));
        assertEquals(0, tokens.size());
    }

    @Test
    void controller() {
        tokens.addAll(List.of(PlayerVerb.CONTROL, Morpheme.ER));
        expected = new AtomicPlayerNode(PlayerVerb.CONTROL, Morpheme.ER);
    }

    @Test
    void owner() {
        tokens.addAll(List.of(PlayerVerb.OWN, Morpheme.ER));
        expected = new AtomicPlayerNode(PlayerVerb.OWN, Morpheme.ER);
    }

    @Test
    void player() {
        tokens.addAll(List.of(PlayerVerb.PLAY, Morpheme.ER));
        expected = new AtomicPlayerNode(PlayerVerb.PLAY, Morpheme.ER);
    }

    @Test
    void opponent() {
        tokens.add(PlayerNoun.OPPONENT);
        expected = new AtomicPlayerNode(PlayerNoun.OPPONENT);
    }

    @Test
    void you() {
        tokens.add(PlayerNoun.YOU);
        expected = new AtomicPlayerNode(PlayerNoun.YOU);
    }

    @Test
    void they() {
        tokens.add(TargetNoun.THEY);
        expected = new AtomicPlayerNode(TargetNoun.THEY);
    }
}
