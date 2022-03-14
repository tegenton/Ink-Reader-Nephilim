package tegenton.card.parser.node;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.InputItem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class KeywordNodeTest extends NodeTest {
    @Test
    void simple() {
        List<Keyword> keywordList =
                List.of(Keyword.BANDING, Keyword.DEFENDER, Keyword.FEAR,
                        Keyword.FLYING, Keyword.HASTE, Keyword.INDESTRUCTIBLE,
                        Keyword.REACH, Keyword.TRAMPLE, Keyword.VIGILANCE);
        for (Keyword keyword : keywordList) {
            ArrayDeque<InputItem> input = new ArrayDeque<>(
                    List.of(new InputItem(keyword),
                            new InputItem((Word) null)));
            testNode(new KeywordNode(keyword), new KeywordNode().productions(),
                    input);
        }
    }

    @Test
    void firstStrike() {
        Deque<InputItem> input = new ArrayDeque<>(
                List.of(new InputItem(Adjective.FIRST),
                        new InputItem(Symbol.SPACE),
                        new InputItem(Keyword.STRIKE),
                        new InputItem((Word) null)));
        testNode(new KeywordNode(Adjective.FIRST, Keyword.STRIKE),
                new KeywordNode().productions(), input);
    }
}
