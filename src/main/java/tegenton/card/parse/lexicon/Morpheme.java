package tegenton.card.parse.lexicon;

/**
 * Morphemes are linguistic units that cannot be divided into smaller parts.
 * They are usually suffixes such as "ed" or "ing"
 */
public enum Morpheme implements Word {
    ER, ING, S;

    @Override
    public String getWord() {
        return this.name();
    }
}
