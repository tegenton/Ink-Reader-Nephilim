package tegenton.card.parser.node;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.item.InputItem;
import tegenton.card.parser.state.Production;
import tegenton.card.parser.state.State;

import java.util.Deque;

public class PermanentNode extends Node {
    private KeywordAbilityNode keywordAbilityNode;

    public PermanentNode(KeywordAbilityNode keywordAbilityNode) {
        this.keywordAbilityNode = keywordAbilityNode;
    }

    public PermanentNode() {
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PermanentNode;
    }

    @Override
    public State productions() {
        return new State(
                Production.of(this, new InputItem(new KeywordAbilityNode())),
                Production.of(this, new InputItem((Word) null)));
    }

    @Override
    public Node apply(Deque<InputItem> stack, InputItem peek) {
        keywordAbilityNode = (KeywordAbilityNode) stack.pop().getNode();
        return this;
    }
}
