package tegenton.card.parser.node;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.game.Keyword;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PermanentNodeTest {
    @Test
    void equality() {
        assertEquals(new PermanentNode(), new PermanentNode());
        assertEquals(new PermanentNode(new KeywordNode(Keyword.BANDING)),
                new PermanentNode(new KeywordNode(Keyword.BANDING)));
    }

    @Test
    void inequality() {
        assertNotEquals(new PermanentNode(),
                new PermanentNode(new KeywordNode(Keyword.BANDING)));
    }
}
