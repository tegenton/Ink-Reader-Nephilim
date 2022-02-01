package tegenton.card.lexicon;

/**
 * Comparatives are used when comparing two values.
 */
public enum Comparative implements Word {
    GREATER,
    LESS,
    MORE,
    THAN;

    @Override
    public String toString() {
        return this.name();
    }
}
