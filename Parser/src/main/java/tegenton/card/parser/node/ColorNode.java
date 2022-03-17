package tegenton.card.parser.node;

import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Comparative;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.ColorWord;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.parser.item.InputClass;
import tegenton.card.parser.item.InputItem;
import tegenton.card.parser.state.Production;
import tegenton.card.parser.state.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class ColorNode extends Node {
    private final List<Word> color = new ArrayList<>();

    ColorNode(Word... value) {
        this.color.addAll(Arrays.asList(value));
    }

    public ColorNode() {
    }

    @Override
    public State productions() {
        return new State(Production.of(this, new InputClass(ColorWord.WHITE)),
                Production.of(this, new InputItem(GameNoun.COLOR),
                        new InputItem(Comparative.LESS)),
                Production.of(this, new InputItem(Adverb.NOT),
                        new InputClass(ColorWord.WHITE)));
    }

    @Override
    public Node apply(Deque<InputItem> stack, InputItem peek) {
        color.add(stack.pop().getWord());
        if (color.get(0) == Comparative.LESS) {
            color.add(0, stack.pop().getWord());
        } else if (stack.size() > 0 && stack.peek().getWord() == Adverb.NOT) {
            color.add(0, stack.pop().getWord());
        }
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
        ColorNode colorNode = (ColorNode) o;
        return Objects.equals(color, colorNode.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
