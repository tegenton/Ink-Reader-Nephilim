package tegenton.card.parser.node;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.source.target.object.ObjectVerb;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdjectiveNodeTest {
    public static List<Word> input;
    public static AdjectiveNode expected;

    @BeforeEach
    void setup() {
        input = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        AdjectiveNode actual = new AdjectiveNode(input);
        assertEquals(expected, actual);
        assertEquals(0, input.size());
    }

    @Test
    void blocked() {
        Collections.addAll(input, ObjectVerb.BLOCK, Morpheme.ED);
        expected = new AdjectiveNode(ObjectVerb.BLOCK);
    }

    @Test
    void enchanted() {
        Collections.addAll(input, Keyword.ENCHANT, Morpheme.ED);
        expected = new AdjectiveNode(Keyword.ENCHANT);
    }

    @Test
    void sacrificed() {
        Collections.addAll(input, PlayerVerb.SACRIFICE, Morpheme.ED);
        expected = new AdjectiveNode(PlayerVerb.SACRIFICE);
    }
}
