package tegenton.card.parser;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.CardNode;
import tegenton.card.parser.node.Node;
import tegenton.card.parser.state.State;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Parser {
    private final Deque<InputItem> input = new ArrayDeque<>();
    private final Deque<InputItem> stack = new ArrayDeque<>();
    private final Deque<State> stateStack = new ArrayDeque<>();

    public Parser(List<Word> tokens) {
        tokens.stream().map(InputItem::new).forEach(input::add);
        stateStack.push(Node.baseProductions());
        input.add(new InputItem((Word) null));
    }

    public CardNode parse() {
        boolean accept = false;
        while (!accept) {
            if (stateStack.getFirst().reducible(input.peek()) != -1) {
                if (stateStack.getFirst().accepting(input.peek())) {
                    accept = true;
                }
                int i = stateStack.getFirst().reducible(input.peek());
                input.push(stateStack.getFirst().reduce(stack, input.peek()));
                for (int j = 0; j < i; j++) {
                    stateStack.pop();
                }
            } else {
                InputItem next = input.pop();
                stateStack.push(stateStack.getFirst().shift(next));
                stack.push(next);
            }
        }
        return (CardNode) input.pop().getNode();
    }
}
