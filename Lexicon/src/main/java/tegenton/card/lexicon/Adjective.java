package tegenton.card.lexicon;

/**
 * Adjectives are a type of premodifier.
 */
public enum Adjective implements Word {
    ADDITIONAL,
    CHOSEN,
    DIFFERENT,
    EQUAL,
    EXTRA,
    FIRST,
    NEW,
    NEXT,
    ROUNDED,
    SAME;

    @Override
    public String toString() {
        return this.name();
    }
}
