package tegenton.card.parser.leaf;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.Node;

import java.util.Objects;

public class Leaf {
    private Node node;
    private Word word;

    private Leaf(final Node n) {
        this.node = n;
    }

    public Leaf(final Word w) {
        word = w;
    }

    public static Leaf of(final Node node) {
        return new Leaf(node);
    }

    public static Leaf of(final Word word) {
        return new Leaf(word);
    }

    public Node getNode() {
        return node;
    }

    public Word getWord() {
        return word;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Leaf leaf = (Leaf) o;
        return Objects.equals(node, leaf.node) && Objects.equals(word,
                leaf.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, word);
    }

    @Override
    public String toString() {
        return (node == null) ? word.toString() : node.toString();
    }
}
