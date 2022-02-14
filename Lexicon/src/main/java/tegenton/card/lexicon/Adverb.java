package tegenton.card.lexicon;

/**
 * Adverbs modify verbs, similarly to how adjectives modify nouns.
 */
public enum Adverb implements Word {
    BACK,
    COMPLETELY,
    EVENLY,
    INSTEAD,
    LIKEWISE,
    NOT,
    ONCE,
    ONLY,
    OVER,
    STILL;

    @Override
    public String toString() {
        return this.name();
    }
}
