package tegenton.card.lexicon.game;

/**
 * The symbol {T} represents a cost of "Tap this permanent".
 */
public enum Tap implements CostSymbol {
    T;

    @Override
    public String toString() {
        return this.name();
    }
}
