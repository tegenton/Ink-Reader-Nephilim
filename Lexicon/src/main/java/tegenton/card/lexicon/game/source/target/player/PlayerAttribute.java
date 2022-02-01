package tegenton.card.lexicon.game.source.target.player;

import tegenton.card.lexicon.Word;

/**
 * Attributes players have.
 */
public enum PlayerAttribute implements Word {
    MAXIMUM,
    SIZE,
    TOTAL;

    @Override
    public String toString() {
        return this.name();
    }
}
