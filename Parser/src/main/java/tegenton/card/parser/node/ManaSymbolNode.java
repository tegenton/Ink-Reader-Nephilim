package tegenton.card.parser.node;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.game.CostSymbol;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.lexicon.value.DigitNumber;
import tegenton.card.lexicon.value.Variable;
import tegenton.card.parser.item.InputClass;
import tegenton.card.parser.item.InputItem;
import tegenton.card.parser.state.Production;
import tegenton.card.parser.state.State;

import java.util.Deque;
import java.util.Objects;

public class ManaSymbolNode extends Node {
    private CostSymbol type;

    public ManaSymbolNode(CostSymbol type) {
        this.type = type;
    }

    public ManaSymbolNode() {
    }

    @Override
    public State productions() {
        return new State(Production.of(this, new InputItem(Symbol.LBRACKET),
                new InputClass(ManaSymbol.W), new InputItem(Symbol.RBRACKET)),
                Production.of(this, new InputItem(Symbol.LBRACKET),
                        new InputClass(new DigitNumber(0)),
                        new InputItem(Symbol.RBRACKET)),
                Production.of(this, new InputItem(Symbol.LBRACKET),
                        new InputClass(Variable.X),
                        new InputItem(Symbol.RBRACKET)));
    }

    @Override
    public Node apply(Deque<InputItem> stack, InputItem peek) {
        stack.pop();
        type = (CostSymbol) stack.pop().getWord();
        stack.pop();
        return this;
    }

    @Override
    public String toString() {
        return '{' + type.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ManaSymbolNode that = (ManaSymbolNode) o;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
