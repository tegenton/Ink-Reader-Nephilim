package tegenton.card.parse.lexicon;

public interface Word {
    /**
     * This does not return the original string, but rather the normalized form
     * of it.
     *
     * @return A string representing this word
     */
    String getWord();
}
