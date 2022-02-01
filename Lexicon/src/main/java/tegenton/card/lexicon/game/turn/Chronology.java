package tegenton.card.lexicon.game.turn;

import tegenton.card.lexicon.Word;

/**
 * Words comparing two points in time.
 */
public enum Chronology implements Word {
    AFTER,
    BEFORE,
    DURING;

    @Override
    public String toString() {
        return this.name();
    }
}
