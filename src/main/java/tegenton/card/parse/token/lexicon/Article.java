package tegenton.card.parse.token.lexicon;

/**
 * Articles are words that define specificity, such as "a" card or "the" card.
 */
public enum Article implements Word {
    a,
    an;

    /**
     * Returns the article represented by s.
     *
     * @param s string that may contain an article
     * @return article contained in s, if s represents one, otherwise null
     */
    public static Article fromString(final String s) {
        for (final Article type : Article.values()) {
            if (type.getWord().equalsIgnoreCase(s)) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String getWord() {
        return name();
    }
}
