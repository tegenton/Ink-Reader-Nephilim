package tegenton.card.parser.node;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.lexicon.value.DigitNumber;
import tegenton.card.lexicon.value.Variable;
import tegenton.card.parser.InputItem;
import tegenton.card.parser.state.State;

import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManaSymbolNodeTest {
    public static Deque<InputItem> inputItems;
    public static Deque<InputItem> stack;
    public static State state;

    @Test
    void specific() throws ParseException {
        for (ManaSymbol symbol : ManaSymbol.values()) {
            inputItems = new ArrayDeque<>(
                    List.of(new InputItem(Symbol.LBRACKET),
                            new InputItem(symbol),
                            new InputItem(Symbol.RBRACKET),
                            new InputItem((Word) null)));
            stack = new ArrayDeque<>();
            state = new ManaSymbolNode().productions();
            while (state.reducible(inputItems.getFirst()) == -1) {
                state = state.shift(inputItems.getFirst());
                stack.push(inputItems.pop());
            }
            assertEquals(new ManaSymbolNode(symbol),
                    state.reduce(stack, inputItems.getFirst()).getNode());
        }
    }

    @Test
    void generic() throws ParseException {
        for (DigitNumber number : DigitNumber.values(5)) {
            inputItems = new ArrayDeque<>(
                    List.of(new InputItem(Symbol.LBRACKET),
                            new InputItem(number),
                            new InputItem(Symbol.RBRACKET),
                            new InputItem((Word) null)));
            stack = new ArrayDeque<>();
            state = new ManaSymbolNode().productions();
            while (state.reducible(inputItems.getFirst()) == -1) {
                state = state.shift(inputItems.getFirst());
                stack.push(inputItems.pop());
            }
            assertEquals(new ManaSymbolNode(number),
                    state.reduce(stack, inputItems.getFirst()).getNode());
        }
    }

    @Test
    void variable() throws ParseException {
        for (Variable x : Variable.values()) {
            inputItems = new ArrayDeque<>(
                    List.of(new InputItem(Symbol.LBRACKET), new InputItem(x),
                            new InputItem(Symbol.RBRACKET),
                            new InputItem((Word) null)));
            stack = new ArrayDeque<>();
            state = new ManaSymbolNode().productions();
            while (state.reducible(inputItems.getFirst()) == -1) {
                state = state.shift(inputItems.getFirst());
                stack.push(inputItems.pop());
            }
            assertEquals(new ManaSymbolNode(x),
                    state.reduce(stack, inputItems.getFirst()).getNode());
        }
    }
}
