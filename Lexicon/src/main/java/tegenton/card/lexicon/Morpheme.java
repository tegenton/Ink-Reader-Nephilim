package tegenton.card.lexicon;

/**
 * Morphemes are linguistic units that cannot be divided into smaller parts.
 */
public enum Morpheme implements Word {
    ED,
    ER,
    ING,
    S;

    @Override
    public String toString() {
        return this.name();
    }
}
