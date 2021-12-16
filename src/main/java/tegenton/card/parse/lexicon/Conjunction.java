package tegenton.card.parse.lexicon;

/**
 * Conjunctions are used to connect things (usually nouns).
 */
public enum Conjunction implements Word {
    AND, OR, THEN;

    @Override
    public String getWord() {
        return this.name();
    }
}
