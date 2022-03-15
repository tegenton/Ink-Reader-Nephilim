package tegenton.card.parser.item;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.Node;

import java.util.Objects;

public class InputItem {
    private Node node;
    private Word word;

    public InputItem(Word word) {
        this.word = word;
    }

    public InputItem(Node node) {
        this.node = node;
    }

    public Word getWord() {
        return word;
    }

    public boolean hasWord() {
        return word != null;
    }

    public Node getNode() {
        return node;
    }

    public boolean hasNode() {
        return node != null;
    }

    @Override
    public String toString() {
        if (hasNode()) {
            return node.toString();
        } else if (hasWord()) {
            return word.toString();
        }
        return "N/A";
    }

    public boolean match(InputItem inputItem) {
        return inputItem != null && Objects.equals(node, inputItem.node)
                && Objects.equals(word, inputItem.word);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InputItem inputItem = (InputItem) o;
        return Objects.equals(node, inputItem.node) && Objects.equals(word,
                inputItem.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, word);
    }
}
