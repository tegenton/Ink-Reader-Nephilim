package tegenton.card.lexicon.game.source.target.player;

import tegenton.card.lexicon.game.source.target.TargetWord;

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
