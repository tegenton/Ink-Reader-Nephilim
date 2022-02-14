package tegenton.card.lexicon;

/**
 * Conjunctions join two or more clauses together.
 */
public enum Conjunction implements Word {
    AND,
    OR,
    THEN,
    UNLESS;

    @Override
    public String toString() {
        return this.name();
    }
}
