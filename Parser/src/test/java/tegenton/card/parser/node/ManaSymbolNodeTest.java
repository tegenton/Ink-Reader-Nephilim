package tegenton.card.parser.node;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.parser.InputItem;
import tegenton.card.parser.state.State;

import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManaSymbolNodeTest {
    @Test
    void specific() throws ParseException {
        Deque<InputItem> inputItems;
        Deque<InputItem> stack;
        ManaSymbolNode manaSymbolNode;
        State state;
        for (ManaSymbol symbol : ManaSymbol.values()) {
            inputItems = new ArrayDeque<>(
                    List.of(new InputItem(Symbol.LBRACKET),
                            new InputItem(symbol),
                            new InputItem(Symbol.RBRACKET),
                            new InputItem((Word) null)));
            stack = new ArrayDeque<>();
            manaSymbolNode = new ManaSymbolNode();
            state = manaSymbolNode.productions();
            while (state.reducible(inputItems.getFirst()) == -1) {
                state = state.shift(inputItems.getFirst());
                stack.push(inputItems.pop());
            }
            state.reduce(stack, inputItems.getFirst());
            assertEquals(new ManaSymbolNode(symbol), manaSymbolNode);
        }
    }
}
