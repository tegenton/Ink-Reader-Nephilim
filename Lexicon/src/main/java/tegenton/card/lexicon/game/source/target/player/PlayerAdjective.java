package tegenton.card.lexicon.game.source.target.player;

import tegenton.card.lexicon.Word;

/**
 * Adjectives that describe players.
 */
public enum PlayerAdjective implements Word {
    ACTIVE,
    DEFENDING;

    @Override
    public String toString() {
        return this.name();
    }
}
