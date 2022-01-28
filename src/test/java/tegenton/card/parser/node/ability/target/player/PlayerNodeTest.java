package tegenton.card.parser.node.ability.target.player;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;
import tegenton.card.parser.node.DeterminerNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerNodeTest {
    public static List<Word> tokens;
    public static PlayerNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        PlayerNode actual = new PlayerNode(tokens);
        assertEquals(expected, actual);
        assertEquals(0, tokens.size());
    }

    @Test
    void targetPlayer() {
        Collections.addAll(tokens, Determiner.TARGET, Symbol.SPACE, PlayerVerb.PLAY, Morpheme.ER);
        expected = new PlayerNode(PlayerVerb.PLAY, new DeterminerNode(Determiner.TARGET));
    }
}
