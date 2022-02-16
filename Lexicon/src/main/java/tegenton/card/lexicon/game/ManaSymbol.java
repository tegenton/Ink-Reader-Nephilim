package tegenton.card.lexicon.game;

/**
 * Mana symbols are used to represent both unspent mana and mana costs.
 */
public enum ManaSymbol implements CostSymbol {
    W,
    U,
    B,
    R,
    G,
    C;

    @Override
    public String toString() {
        return this.name();
    }
}
