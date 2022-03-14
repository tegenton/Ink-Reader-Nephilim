package tegenton.card.parser.node;

import tegenton.card.parser.InputItem;
import tegenton.card.parser.state.State;

import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class NodeTest {
    protected void testNode(Node expected, State state,
                            Deque<InputItem> input) {
        Deque<InputItem> stack = new ArrayDeque<>();
        while (state.reducible(input.getFirst()) == -1) {
            state = state.shift(input.getFirst());
            stack.push(input.pop());
        }
        try {
            assertEquals(expected,
                    state.reduce(stack, input.getFirst()).getNode());
        } catch (ParseException e) {
            e.printStackTrace();
            fail();
        }
    }
}
