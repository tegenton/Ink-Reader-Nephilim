package tegenton.card.lexicon.value;

import tegenton.card.lexicon.Word;

/**
 * Common interface for value words.
 */
public interface ValueWord extends Word {
    /**
     * Retrieve the numeric value represented by this word.
     *
     * @return The integer value of the word.
     */
    int getValue();
}
