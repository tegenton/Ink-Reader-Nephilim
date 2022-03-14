package tegenton.card.parser.node;

import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.InputClass;
import tegenton.card.parser.InputItem;
import tegenton.card.parser.state.Production;
import tegenton.card.parser.state.State;

import java.util.Deque;
import java.util.Objects;

public class KeywordNode extends Node {
    private Word keyword;

    public KeywordNode(Keyword word) {
        this.keyword = word;
    }

    KeywordNode() {
        keyword = null;
    }

    public KeywordNode(Adjective first, Keyword strike) {
        keyword = first;
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
        return new State(Production.of(this, new InputClass(Keyword.class)),
                Production.of(this, new InputItem(Adjective.FIRST),
                        new InputItem(Symbol.SPACE),
                        new InputItem(Keyword.STRIKE)));
    }

    @Override
    public Node apply(Deque<InputItem> stack, InputItem peek) {
        if (stack.getFirst().getWord() == Keyword.STRIKE) {
            stack.pop(); // STRIKE
            stack.pop(); // SPACE
        }
        keyword = stack.pop().getWord();
        return this;
    }
}
