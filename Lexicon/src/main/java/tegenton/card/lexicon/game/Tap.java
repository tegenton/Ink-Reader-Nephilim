package tegenton.card.lexicon.game;

import tegenton.card.lexicon.Word;

/**
 * The symbol {T} represents a cost of "Tap this permanent".
 */
public enum Tap implements Word {
    T;

    @Override
    public String toString() {
        return this.name();
    }
}
