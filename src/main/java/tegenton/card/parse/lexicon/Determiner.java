package tegenton.card.parse.lexicon;

/**
 * Articles are words that define specificity, such as "a" card or "the" card.
 */
public enum Determiner implements Word {
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
