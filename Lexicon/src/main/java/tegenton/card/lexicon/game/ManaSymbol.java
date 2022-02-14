package tegenton.card.lexicon.game;

import tegenton.card.lexicon.Word;

/**
 * Mana symbols are used to represent both unspent mana and mana costs.
 */
public enum ManaSymbol implements Word {
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
