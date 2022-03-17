package tegenton.card.parser.node;

import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.game.type.CreatureType;
import tegenton.card.lexicon.game.type.EnchantmentType;
import tegenton.card.lexicon.game.type.LandType;
import tegenton.card.lexicon.game.type.SuperType;
import tegenton.card.parser.item.InputClass;
import tegenton.card.parser.item.InputItem;
import tegenton.card.parser.state.Production;
import tegenton.card.parser.state.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class TypeNode extends Node {
    private final List<Word> value = new ArrayList<>();

    public TypeNode(Word... words) {
        value.addAll(Arrays.asList(words));
    }

    @Override
    public State productions() {
        return new State(Production.of(this, new InputClass(SuperType.BASIC)),
                Production.of(this, new InputClass(CardType.ARTIFACT)),
                Production.of(this, new InputClass(CreatureType.WALL)),
                Production.of(this, new InputClass(EnchantmentType.AURA)),
                Production.of(this, new InputClass(LandType.PLAINS)),
                Production.of(this, new InputItem(Adjective.CHOSEN),
                        new InputItem(Symbol.SPACE),
                        new InputItem(GameNoun.TYPE)));
    }

    @Override
    public Node apply(Deque<InputItem> stack, InputItem peek) {
        if (stack.getFirst().getWord() == GameNoun.TYPE) {
            value.add(stack.pop().getWord());
            stack.pop();
        }
        value.add(0, stack.pop().getWord());
        return this;
    }

    @Override
    public String toString() {
        return "TypeNode{" + value + '}';
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
        return Objects.equals(value, typeNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
