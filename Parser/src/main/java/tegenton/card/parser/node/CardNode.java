package tegenton.card.parser.node;

import tegenton.card.parser.item.InputItem;
import tegenton.card.parser.state.Production;
import tegenton.card.parser.state.State;

import java.util.Deque;
import java.util.Objects;

public class CardNode extends Node {
    private Node node;

    public CardNode(PermanentNode permanentNode) {
        node = permanentNode;
    }

    CardNode() {
        node = null;
    }

    public State productions() {
        Production p = Production.of(this, new InputItem(new PermanentNode()));
        p.setAccepting(true);
        return new State(p);
    }

    @Override
    public Node apply(Deque<InputItem> stack, InputItem peek) {
        this.node = stack.pop().getNode();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CardNode cardNode = (CardNode) o;
        return Objects.equals(node, cardNode.node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node);
    }
}
