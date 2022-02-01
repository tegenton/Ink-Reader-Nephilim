package tegenton.card.lexicon;

/**
 * Pronouns represent something previously mentioned.
 */
public enum Pronoun implements Word {
    SO;

    @Override
    public String toString() {
        return this.name();
    }
}
