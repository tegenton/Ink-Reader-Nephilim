package tegenton.card.parser.node;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.item.InputItem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ConjunctionNodeTest extends NodeTest {
    @Test
    void simple() {
        List<Conjunction> conjunctionList =
                List.of(Conjunction.AND, Conjunction.OR, Conjunction.THEN);
        for (Conjunction conjunction : conjunctionList) {
            Deque<InputItem> input = new ArrayDeque<>(
                    List.of(new InputItem(conjunction),
                            new InputItem((Word) null)));
            testNode(new ConjunctionNode(conjunction), input);
        }
    }

    @Test
    void andOr() {
        Deque<InputItem> input = new ArrayDeque<>(
                List.of(new InputItem(Conjunction.AND),
                        new InputItem(Symbol.SLASH),
                        new InputItem(Conjunction.OR),
                        new InputItem((Word) null)));
        testNode(new ConjunctionNode(Conjunction.AND, Symbol.SLASH,
                Conjunction.OR), input);
    }
}
