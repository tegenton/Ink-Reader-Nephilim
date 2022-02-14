package tegenton.card.lexicon;

/**
 * Prepositions mark the start of a prepositional phrase.
 */
public enum Preposition implements Word {
    ABOVE,
    ADDITION,
    AMONG,
    BEYOND,
    BY,
    FOR,
    FROM,
    IN,
    MINUS,
    OF,
    ON,
    OUT,
    TO,
    UNDER,
    WITH;

    @Override
    public String toString() {
        return this.name();
    }
}
