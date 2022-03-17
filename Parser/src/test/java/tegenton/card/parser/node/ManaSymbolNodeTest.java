package tegenton.card.parser.node;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.lexicon.value.DigitNumber;
import tegenton.card.lexicon.value.Variable;
import tegenton.card.parser.item.InputItem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ManaSymbolNodeTest extends NodeTest {
    @Test
    void specific() {
        for (ManaSymbol symbol : ManaSymbol.values()) {
            Deque<InputItem> input = new ArrayDeque<>(
                    List.of(new InputItem(Symbol.LBRACKET),
                            new InputItem(symbol),
                            new InputItem(Symbol.RBRACKET),
                            new InputItem((Word) null)));
            testNode(new ManaSymbolNode(symbol), input);
        }
    }

    @Test
    void generic() {
        for (DigitNumber number : DigitNumber.values(5)) {
            Deque<InputItem> input = new ArrayDeque<>(
                    List.of(new InputItem(Symbol.LBRACKET),
                            new InputItem(number),
                            new InputItem(Symbol.RBRACKET),
                            new InputItem((Word) null)));
            testNode(new ManaSymbolNode(number), input);
        }
    }

    @Test
    void variable() {
        for (Variable variable : Variable.values()) {
            Deque<InputItem> input = new ArrayDeque<>(
                    List.of(new InputItem(Symbol.LBRACKET),
                            new InputItem(variable),
                            new InputItem(Symbol.RBRACKET),
                            new InputItem((Word) null)));
            testNode(new ManaSymbolNode(variable), input);
        }
    }
}
