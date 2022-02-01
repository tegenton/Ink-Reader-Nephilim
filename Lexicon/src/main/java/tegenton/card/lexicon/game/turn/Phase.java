package tegenton.card.lexicon.game.turn;

import tegenton.card.lexicon.Word;

/**
 * The phases of a turn are beginning, main, and combat.
 */
public enum Phase implements Word {
    BEGINNING,
    MAIN,
    COMBAT;

    @Override
    public String toString() {
        return this.name();
    }
}
