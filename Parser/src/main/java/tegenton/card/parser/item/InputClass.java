package tegenton.card.parser.item;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.Node;

import java.util.Objects;

public class InputClass extends InputItem {
    private final Class<? extends Word> wordClass;
    private final Class<? extends Node> nodeClass;

    /**
     * Create a new InputClass that matches a particular type.
     *
     * @param type Type that this item should match.
     */
    public InputClass(final Word type) {
        super(type);
        wordClass = type.getClass();
        nodeClass = null;
    }

    public InputClass(final Node type) {
        super(type);
        wordClass = null;
        nodeClass = type.getClass();
    }

    /**
     * Check an item against this item's class.
     *
     * @param inputItem Item to compare.
     * @return Is that item of the given class?
     */
    @Override
    public boolean match(final InputItem inputItem) {
        if (inputItem.hasWord()) {
            return inputItem.getWord().getClass() == wordClass;
        } else if (inputItem.hasNode()) {
            return inputItem.getNode().getClass() == nodeClass;
        }
        return false;
    }

    /**
     * Get the name of the class this item matches.
     *
     * @return String representation of this item.
     */
    @Override
    public String toString() {
        if (wordClass != null) {
            return wordClass.getSimpleName();
        } else if (nodeClass != null) {
            return nodeClass.getSimpleName();
        }
        return "Empty Class";
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
        if (!super.equals(o)) {
            return false;
        }
        InputClass that = (InputClass) o;
        return Objects.equals(wordClass, that.wordClass);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wordClass);
    }
}
