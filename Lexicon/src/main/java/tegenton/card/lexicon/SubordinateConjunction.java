package tegenton.card.lexicon;

/**
 * Subordinate conjunctions mark the start of a subordinate clause.
 */
public enum SubordinateConjunction implements Word {
    AS,
    BUT,
    EXCEPT,
    IF,
    LONG,
    THOUGH,
    WHERE;

    @Override
    public String toString() {
        return this.name();
    }
}
