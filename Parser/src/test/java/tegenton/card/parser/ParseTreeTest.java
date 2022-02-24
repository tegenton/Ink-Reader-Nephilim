package tegenton.card.parser;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.ability.KeywordNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ParseTreeTest {
    @Test
    void equals() {
        assertEquals(new ParseTree(), new ParseTree());
    }

    @Test
    void notEquals() {
        assertNotEquals(new ParseTree(), new ParseTree(new CardNode(
                new PermanentNode(new KeywordNode(Keyword.BANDING)))));
    }
}
