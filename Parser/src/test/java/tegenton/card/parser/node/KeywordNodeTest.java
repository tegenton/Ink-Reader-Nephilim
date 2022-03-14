package tegenton.card.parser.node;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.InputItem;
import tegenton.card.parser.state.State;

import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KeywordNodeTest {
    @Test
    void simple() throws ParseException {
        List<Keyword> keywordList =
                List.of(Keyword.BANDING, Keyword.DEFENDER, Keyword.FEAR,
                        Keyword.FLYING, Keyword.HASTE, Keyword.INDESTRUCTIBLE,
                        Keyword.REACH, Keyword.TRAMPLE, Keyword.VIGILANCE);
        KeywordNode keywordNode = new KeywordNode();
        for (Keyword keyword : keywordList) {
            InputItem item = new InputItem(keyword);
            Deque<InputItem> stack = new ArrayDeque<>();
            stack.add(item);
            keywordNode.productions().shift(item)
                    .reduce(stack, new InputItem((Word) null));
            assertEquals(new KeywordNode(keyword), keywordNode);
        }
    }

    @Test
    void firstStrike() throws ParseException {
        Deque<InputItem> inputItems = new ArrayDeque<>(
                List.of(new InputItem(Adjective.FIRST),
                        new InputItem(Symbol.SPACE),
                        new InputItem(Keyword.STRIKE),
                        new InputItem((Word) null)));
        Deque<InputItem> stack = new ArrayDeque<>();
        KeywordNode keywordNode = new KeywordNode();
        State state = keywordNode.productions();
        while (state.reducible(inputItems.getFirst()) == -1) {
            state = state.shift(inputItems.getFirst());
            stack.push(inputItems.pop());
        }
        state.reduce(stack, inputItems.getFirst());
        assertEquals(new KeywordNode(Adjective.FIRST, Keyword.STRIKE),
                keywordNode);
    }
}
