package tegenton.card.lexicon;

/**
 * Determiners are words that define specificity, such as "a" card or "the"
 * card.
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
    public String getWord() {
        return name();
    }
}
