package tegenton.card.parser.item;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.Node;

import java.util.Objects;

public class InputItem {
    private final Node node;
    private final Word word;

    /**
     * Create a new InputItem holding a given word.
     *
     * @param value Value of this item.
     */
    public InputItem(final Word value) {
        word = value;
        node = null;
    }

    /**
     * Create a new InputItem holding a given node.
     *
     * @param value Value of this item.
     */
    public InputItem(final Node value) {
        word = null;
        node = value;
    }

    /**
     * Retrieve the word contained by this item if applicable, otherwise null.
     *
     * @return Value of this item.
     */
    public Word getWord() {
        return word;
    }

    /**
     * If this method returns false, getWord will return null.
     *
     * @return Does this item contain a word?
     */
    public boolean hasWord() {
        return word != null;
    }

    /**
     * Retrieve the node contained by this item if applicable, otherwise null.
     *
     * @return Value of this item.
     */
    public Node getNode() {
        return node;
    }

    /**
     * If this method returns false, getNode will return null.
     *
     * @return Does this item contain a node?
     */
    public boolean hasNode() {
        return node != null;
    }

    /**
     * Compare items.
     *
     * @param inputItem Item to compare.
     * @return Does the given item match this item's requirements?
     */
    public boolean match(final InputItem inputItem) {
        return inputItem != null && Objects.equals(node, inputItem.node)
                && Objects.equals(word, inputItem.word);
    }

    /**
     * Get the string value of the word or node this item contains, or "Empty
     * Item".
     *
     * @return String representing contents of this item.
     */
    @Override
    public String toString() {
        if (hasNode()) {
            return node.toString();
        } else if (hasWord()) {
            return word.toString();
        }
        return "Empty Item";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(node, word);
    }
}
