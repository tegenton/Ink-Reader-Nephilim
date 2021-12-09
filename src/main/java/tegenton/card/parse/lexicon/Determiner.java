package tegenton.card.parse.lexicon;

/**
 * Articles are words that define specificity, such as "a" card or "the" card.
 */
public enum Determiner implements Word {
    // Determiner types
    // Articles
    A,
    AN,
    THE,
    // Demonstrative
    TARGET,
    THIS,
    THESE,
    THAT,
    THOSE,
    // Negative
    NO,
    // Alternative
    OTHER,
    // Alternative-addative
    ANOTHER,
    // Universal
    ALL,
    // Distributive
    EACH,
    // Existential
    ANY;

    @Override
    public String getWord() {
        return name();
    }
}
