package tegenton.card.parser.node;

import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.game.type.SuperType;
import tegenton.card.lexicon.game.type.TypeWord;
import tegenton.card.parser.item.InputClass;
import tegenton.card.parser.item.InputItem;
import tegenton.card.parser.state.Production;
import tegenton.card.parser.state.State;

import java.util.Deque;
import java.util.Objects;

public class TypeNode extends Node {
    private TypeWord typeWord;

    public TypeNode(TypeWord basic) {
        typeWord = basic;
    }

    @Override
    public State productions() {
        return new State(Production.of(this, new InputClass(SuperType.BASIC)),
                Production.of(this, new InputClass(CardType.ARTIFACT)));
    }

    @Override
    public Node apply(Deque<InputItem> stack, InputItem peek) {
        typeWord = (TypeWord) stack.pop().getWord();
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
        TypeNode typeNode = (TypeNode) o;
        return Objects.equals(typeWord, typeNode.typeWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeWord);
    }
}
