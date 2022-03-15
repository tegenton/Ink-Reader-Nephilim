package tegenton.card.parser.node;

import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.parser.AnyExceptItem;
import tegenton.card.parser.InputItem;
import tegenton.card.parser.state.Production;
import tegenton.card.parser.state.State;

import java.util.Deque;
import java.util.Objects;

public class ConjunctionNode extends Node {
    private Word conjunction;

    public ConjunctionNode(Conjunction and, Symbol slash, Conjunction or) {
        conjunction = slash;
    }

    public ConjunctionNode(Conjunction conjunction) {
        this.conjunction = conjunction;
    }

    public ConjunctionNode() {
    }

    @Override
    public State productions() {
        Production p = Production.of(this, new InputItem(Conjunction.AND));
        p.setLookahead(new AnyExceptItem(Symbol.SLASH));
        return new State(p, Production.of(this, new InputItem(Conjunction.OR)),
                Production.of(this, new InputItem(Conjunction.THEN)),
                Production.of(this, new InputItem(Conjunction.AND),
                        new InputItem(Symbol.SLASH),
                        new InputItem(Conjunction.OR)));
    }

    @Override
    public Node apply(Deque<InputItem> stack, InputItem peek) {
        conjunction = stack.pop().getWord();
        if (stack.peek() != null && stack.peek().getWord() == Symbol.SLASH) {
            conjunction = stack.pop().getWord();
            stack.pop();
        }
        return this;
    }

    @Override
    public String toString() {
        return "ConjunctionNode{" + "conjunction=" + conjunction + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConjunctionNode that = (ConjunctionNode) o;
        return conjunction == that.conjunction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(conjunction);
    }
}
