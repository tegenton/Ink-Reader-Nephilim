package tegenton.card.parser.item;

import tegenton.card.lexicon.Word;

import java.util.Objects;

public class InputClass extends InputItem {
    private final Class<? extends Word> wordClass;

    /**
     * Create a new InputClass that matches a particular word.
     *
     * @param wordType Type of word that this item should match.
     */
    public InputClass(final Class<? extends Word> wordType) {
        super((Word) null);
        wordClass = wordType;
    }

    /**
     * Check an item against this item's class.
     *
     * @param inputItem Item to compare.
     * @return Is that item of the given class?
     */
    @Override
    public boolean match(final InputItem inputItem) {
        return inputItem.hasWord()
                && inputItem.getWord().getClass() == wordClass;
    }

    /**
     * Get the name of the word class this item matches.
     *
     * @return String representation of this item.
     */
    @Override
    public String toString() {
        return wordClass.getSimpleName();
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
