package tegenton.card.parser.node;

import tegenton.card.parser.item.InputItem;
import tegenton.card.parser.state.State;

import java.util.Deque;

public abstract class Node implements Cloneable {
    public static State baseProductions() {
        return new CardNode().productions();
    }

    public abstract State productions();

    public abstract Node apply(Deque<InputItem> stack, InputItem peek);

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
