package tegenton.card.parser;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.item.InputItem;
import tegenton.card.parser.node.CardNode;
import tegenton.card.parser.node.Node;
import tegenton.card.parser.state.State;

import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Parser {
    private final Deque<InputItem> input = new ArrayDeque<>();
    private final Deque<InputItem> stack = new ArrayDeque<>();
    private final Deque<State> stateStack = new ArrayDeque<>();

    public Parser(List<Word> inputItemList) {
        inputItemList.stream().map(InputItem::new).forEach(input::add);
        input.add(new InputItem((Word) null));
    }

    public Parser(Deque<InputItem> inputItems) {
        input.addAll(inputItems);
    }

    public CardNode parse() throws ParseException {
        stateStack.push(CardNode.baseProductions());
        while (true) {
            if (input.peek() != null) {
                if (input.peek().getNode() instanceof CardNode cardNode) {
                    return cardNode;
                }
                if (!reduce()) {
                    shift();
                }
            } else {
                if (!reduce()) {
                    return null;
                }
            }
        }
    }

    public Node parse(Node expect) throws ParseException {
        stateStack.push(expect.productions());
        while (true) {
            if (input.peek() != null) {
                if (input.peek().hasNode() && input.peek().getNode().getClass()
                        == expect.getClass()) {
                    return input.pop().getNode();
                }
                if (!reduce()) {
                    shift();
                }
            } else {
                if (!reduce()) {
                    return null;
                }
            }
        }
    }

    private void shift() {
        InputItem next = input.pop();
        stack.push(next);
        stateStack.push(stateStack.getFirst().shift(next));
    }

    private boolean reduce() throws ParseException {
        InputItem next = input.peek();
        int n = stateStack.getFirst().reducible(next);
        if (n != -1) {
            input.push(stateStack.getFirst().reduce(stack, next));
            for (int i = 0; i < n; i++) {
                stateStack.pop();
            }
            return true;
        }
        return false;
    }
}
