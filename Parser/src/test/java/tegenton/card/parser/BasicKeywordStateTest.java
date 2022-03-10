package tegenton.card.parser;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.node.KeywordNode;
import tegenton.card.parser.state.BasicKeywordState;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicKeywordStateTest {
    public static BasicKeywordState state = new BasicKeywordState();

    @Test
    void comma() {
        assertEquals(1, state.reducible(new InputItem(Symbol.COMMA)));
    }

    @Test
    void newline() {
        assertEquals(1, state.reducible(new InputItem(Symbol.NEWLINE)));
    }

    @Test
    void semicolon() {
        assertEquals(1, state.reducible(new InputItem(Symbol.SEMICOLON)));
    }

    @Test
    void space() {
        assertEquals(1, state.reducible(new InputItem(Symbol.SPACE)));
    }

    @Test
    void basic() {
        List<Keyword> keywords =
                List.of(Keyword.BANDING, Keyword.DEFENDER, Keyword.FEAR,
                        Keyword.FLYING, Keyword.HASTE, Keyword.INDESTRUCTIBLE,
                        Keyword.REACH, Keyword.TRAMPLE, Keyword.VIGILANCE);
        for (Keyword keyword : keywords) {
            KeywordNode expected = new KeywordNode(keyword);
            InputItem actual = state.reduce(List.of(new InputItem(keyword)));
            assertEquals(expected, actual.getNode());
        }
    }
}
