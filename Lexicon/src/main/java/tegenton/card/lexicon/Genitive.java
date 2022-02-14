package tegenton.card.lexicon;

/**
 * Genitives indicate relationships between nouns.
 */
public enum Genitive implements Word {
    HALF;

    @Override
    public String toString() {
        return this.name();
    }
}
