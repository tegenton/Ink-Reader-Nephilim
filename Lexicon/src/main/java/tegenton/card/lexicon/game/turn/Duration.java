package tegenton.card.lexicon.game.turn;

import tegenton.card.lexicon.Word;

/**
 * Words representing a period of time.
 */
public enum Duration implements Word {
    SINCE,
    UNTIL,
    WHILE;

    @Override
    public String toString() {
        return this.name();
    }
}
