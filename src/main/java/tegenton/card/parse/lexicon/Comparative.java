package tegenton.card.parse.lexicon;

/**
 * For comparing two values.
 */
public enum Comparative implements Word {
    GREATER, LESS, MORE, THAN;

    @Override
    public String getWord() {
        return this.name();
    }
}
