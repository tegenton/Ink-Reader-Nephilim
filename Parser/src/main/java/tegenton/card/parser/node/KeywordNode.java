package tegenton.card.parser.node;

import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.type.CardType;
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
    private final List<InputItem> value = new ArrayList<>();

    public KeywordNode(InputItem... items) {
        this.value.addAll(Arrays.asList(items));
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
        return Objects.equals(value, ((KeywordNode) o).value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "KeywordNode{" + value + '}';
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
                        new InputClass(new ColorNode())),
                Production.of(this, new InputClass(new TypeNode(CardType.LAND)),
                        new InputItem(Keyword.WALK)));
    }

    @Override
    public Node apply(Deque<InputItem> stack, InputItem peek) {
        if (stack.getFirst().getWord() == Keyword.STRIKE) {
            value.add(0, stack.pop()); // FIRST
            stack.pop(); // SPACE
        } else if (stack.getFirst().getNode() instanceof ColorNode) {
            value.add(0, stack.pop()); // COLOR
            stack.pop(); // SPACE
            value.add(0, stack.pop()); // FROM
            stack.pop(); // SPACE
        }
        value.add(0, stack.pop());
        return this;
    }
}
