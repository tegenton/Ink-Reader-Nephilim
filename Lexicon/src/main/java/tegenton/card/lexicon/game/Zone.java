package tegenton.card.lexicon.game;

import tegenton.card.lexicon.Word;

/**
 * Zones can contain any number of cards, and the cards may be public, private,
 * or hidden.
 */
public enum Zone implements Word {
    ANTE,
    BATTLEFIELD,
    DECK,
    EXILE,
    GRAVEYARD,
    HAND,
    LIBRARY;

    @Override
    public String toString() {
        return this.name();
    }
}
