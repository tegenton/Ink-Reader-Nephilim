package tegenton.card.parser.node;

import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.item.ClassExcept;
import tegenton.card.parser.item.InputClass;
import tegenton.card.parser.item.InputItem;
import tegenton.card.parser.state.Production;
import tegenton.card.parser.state.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class KeywordNode extends Node {
    private final List<Word> keyword = new ArrayList<>();

    public KeywordNode(Word... value) {
        keyword.addAll(Arrays.asList(value));
    }

    KeywordNode() {
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
        return Objects.equals(keyword, ((KeywordNode) o).keyword);
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
        return new State(
                Production.of(this, new ClassExcept(Keyword.PROTECTION)),
                Production.of(this, new InputItem(Adjective.FIRST),
                        new InputItem(Symbol.SPACE),
                        new InputItem(Keyword.STRIKE)),
                Production.of(this, new InputItem(Keyword.PROTECTION),
                        new InputItem(Symbol.SPACE),
                        new InputItem(Preposition.FROM),
                        new InputItem(Symbol.SPACE),
                        new InputClass(new ColorNode())));
    }

    @Override
    public Node apply(Deque<InputItem> stack, InputItem peek) {
        if (stack.getFirst().getWord() == Keyword.STRIKE) {
            keyword.add(0, stack.pop().getWord()); // FIRST
            stack.pop(); // SPACE
        } else if (stack.getFirst().getNode() instanceof ColorNode) {
            keyword.add(0, stack.pop().getWord()); // COLOR
            stack.pop(); // SPACE
            keyword.add(0, stack.pop().getWord()); // FROM
            stack.pop(); // SPACE
        }
        keyword.add(0, stack.pop().getWord());
        return this;
    }
}
