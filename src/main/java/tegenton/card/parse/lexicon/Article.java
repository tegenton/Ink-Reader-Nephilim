package tegenton.card.parse.lexicon;

/**
 * Articles are words that define specificity, such as "a" card or "the" card.
 */
public enum Article implements Word {
    a,
    an;

    @Override
    public String getWord() {
        return name();
    }
}
