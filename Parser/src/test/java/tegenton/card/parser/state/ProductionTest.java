package tegenton.card.parser.state;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.node.KeywordNode;
import tegenton.card.parser.node.PermanentNode;

import static org.junit.jupiter.api.Assertions.*;

public class ProductionTest {
    public static Production production;

    @Test
    void empty() {
        production = new Production(new PermanentNode());
        production.add(null);
        assertTrue(production.accept(null));
        assertTrue(production.reducable());
        assertEquals(new PermanentNode(), production.reduce());
    }

    @Test
    void keyword() {
        production = new Production(new KeywordNode(Keyword.BANDING));
        production.add(Keyword.BANDING);
        assertTrue(production.accept(Keyword.BANDING));
        assertTrue(production.reducable());
        assertEquals(new KeywordNode(Keyword.BANDING), production.reduce());
    }

    @Test
    void multiword() {
        production = new Production(new KeywordNode());
        production.add(Adjective.FIRST);
        production.add(Symbol.SPACE);
        production.add(Keyword.STRIKE);
        assertTrue(production.accept(Adjective.FIRST));
        assertTrue(production.accept(Symbol.SPACE));
        assertTrue(production.accept(Keyword.STRIKE));
        assertEquals(new KeywordNode(Adjective.FIRST, Keyword.STRIKE),
                production.reduce());
    }

    @Test
    void reject() {
        production = new Production(new PermanentNode());
        production.add(null);
        assertFalse(production.accept(Keyword.BANDING));
    }

    @Test
    void incomplete() {
        production = new Production(new PermanentNode());
        production.add(Adjective.FIRST);
        production.add(Symbol.SPACE);
        production.add(Keyword.STRIKE);
        assertTrue(production.accept(Adjective.FIRST));
        assertTrue(production.accept(Symbol.SPACE));
        assertFalse(production.reducable());
    }
}
