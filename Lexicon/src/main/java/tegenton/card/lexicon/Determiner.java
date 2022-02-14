package tegenton.card.lexicon;

/**
 * Determiners are premodifiers that define specificity.
 */
public enum Determiner implements Word {
    // Articles
    A, AN, THE,
    // Demonstrative
    TARGET, THIS, THESE, THAT, THOSE,
    // Negative
    NO,
    // Alternative
    OTHER,
    // Alternative-additive
    ANOTHER,
    // Degree
    LEAST, MANY,
    // Universal
    ALL,
    // Distributive
    EACH,
    // Existential
    ANY,
    SOME;

    @Override
    public String toString() {
        return name();
    }
}
