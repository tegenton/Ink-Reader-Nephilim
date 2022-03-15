package tegenton.card.parser.node;

import tegenton.card.parser.item.InputItem;
import tegenton.card.parser.state.Production;
import tegenton.card.parser.state.State;

import java.util.Deque;

public class KeywordAbilityNode extends Node {
    private KeywordNode keywordNode;

    public KeywordAbilityNode(KeywordNode keywordNode) {
        this.keywordNode = keywordNode;
    }

    KeywordAbilityNode() {

    }

    @Override
    public State productions() {
        return new State(Production.of(this, new InputItem(new KeywordNode())));
    }

    @Override
    public Node apply(Deque<InputItem> stack, InputItem peek) {
        keywordNode = (KeywordNode) stack.pop().getNode();
        return this;
    }
}
