package tegenton.card.lexicon;

/**
 * Nouns represent people, places, or things.
 */
public enum Noun implements Word {
    AMOUNT,
    CHOICE,
    FEWEST,
    FOOT,
    HEIGHT,
    INSTANCE,
    LABEL,
    NUMBER,
    ORDER,
    RANDOM,
    REST,
    TEXT,
    TIME,
    WAY,
    WORD;

    @Override
    public String toString() {
        return this.name();
    }
}
