package tegenton.card.parser.node;

import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.InputItem;
import tegenton.card.parser.state.Production;
import tegenton.card.parser.state.State;

import java.util.Deque;
import java.util.Objects;

public class KeywordNode extends Node {
    private Keyword keyword;

    public KeywordNode(Keyword word) {
        this.keyword = word;
    }

    KeywordNode() {
        keyword = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KeywordNode that = (KeywordNode) o;
        return keyword == that.keyword;
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyword);
    }

    @Override
    public String toString() {
        return "KeywordNode{" + keyword + '}';
    }

    @Override
    public State productions() {
        return new State(Production.of(this, new InputItem(Keyword.BANDING)));
    }

    @Override
    public Node apply(Deque<InputItem> stack, InputItem peek) {
        keyword = (Keyword) stack.pop().getWord();
        return this;
    }
}
