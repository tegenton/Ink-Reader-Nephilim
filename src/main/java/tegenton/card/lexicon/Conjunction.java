package tegenton.card.lexicon;

/**
 * Conjunctions are used to connect things (usually nouns).
 */
public enum Conjunction implements Word {
    AND, OR, THEN, UNLESS;

    @Override
    public String getWord() {
        return this.name();
    }
}
