package tegenton.card.lexicon;

/**
 * Parent interface for every lexeme and morpheme.
 */
public interface Word {
    /**
     * While enum objects have a "name" method, that returns the literal enum
     * name, rather than the string it represents.
     *
     * @return String representation of this word.
     */
    String toString();
}
