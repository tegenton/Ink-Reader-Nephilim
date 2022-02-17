package tegenton.card.parser.node.leaf;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.parser.node.CardNode;
import tegenton.card.parser.node.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeafTest {
    @Test
    void node() {
        final Node test = new CardNode(null);
        final Leaf leaf = Leaf.of(test);
        assertEquals(test, leaf.getNode());
    }

    @Test
    void word() {
        final Word test = PlayerVerb.PLAY;
        final Leaf leaf = Leaf.of(test);
        assertEquals(test, leaf.getWord());
    }
}
