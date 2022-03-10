package tegenton.card.parser;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.CardNode;
import tegenton.card.parser.state.CardState;
import tegenton.card.parser.state.State;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Parser {
    private final Deque<InputItem> input = new ArrayDeque<>();
    private final Deque<InputItem> stack = new ArrayDeque<>();
    private final Deque<State> stateStack = new ArrayDeque<>();

    public Parser(List<Word> tokens) {
        tokens.stream().map(InputItem::new).forEach(input::add);
        stateStack.push(new CardState());
        input.add(new InputItem((Word) null));
    }

    public CardNode parse() {
        while (!stateStack.isEmpty()) {
            if (stateStack.peek().reducible(input.peek()) != -1) {
                reduce(input.peek());
            } else {
                shift(input.pop());
            }
        }
        return (CardNode) input.pop().getNode();
    }

    private void shift(InputItem item) {
        stack.push(item);
        State next = null;
        if (stateStack.peek() != null) {
            next = stateStack.peek().shift(item);
        }
        if (next != null) {
            stateStack.push(next);
        }
    }

    private void reduce(InputItem lookahead) {
        int count = 0;
        if (stateStack.peek() != null) {
            count = stateStack.peek().reducible(lookahead);
        }
        List<InputItem> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            items.add(stack.pop());
        }
        if (stateStack.peek() != null) {
            input.push(stateStack.peek().reduce(items));
        }
        for (int i = 0; i < count; i++) {
            stateStack.pop();
        }
    }
}
