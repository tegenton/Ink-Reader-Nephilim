package tegenton.card.lexicon.game.target.player;

import tegenton.card.lexicon.game.target.TargetWord;

/**
 * Nouns that refer to players.
 */
public enum PlayerNoun implements TargetWord {
    OPPONENT,
    YOU;

    @Override
    public String toString() {
        return this.name();
    }
}
