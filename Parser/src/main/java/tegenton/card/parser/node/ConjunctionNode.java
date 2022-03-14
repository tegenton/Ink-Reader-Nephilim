package tegenton.card.parser.node;

import tegenton.card.lexicon.Conjunction;
import tegenton.card.parser.InputItem;
import tegenton.card.parser.state.Production;
import tegenton.card.parser.state.State;

import java.util.Deque;
import java.util.Objects;

public class ConjunctionNode extends Node {
    private Conjunction conjunction;

    public ConjunctionNode(Conjunction conjunction) {
        this.conjunction = conjunction;
    }

    public ConjunctionNode() {
    }

    @Override
    public State productions() {
        return new State(Production.of(this, new InputItem(Conjunction.AND)),
                Production.of(this, new InputItem(Conjunction.OR)),
                Production.of(this, new InputItem(Conjunction.THEN)));
    }

    @Override
    public Node apply(Deque<InputItem> stack, InputItem peek) {
        conjunction = (Conjunction) stack.pop().getWord();
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
