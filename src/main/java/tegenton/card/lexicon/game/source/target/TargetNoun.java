package tegenton.card.lexicon.game.source.target;

import tegenton.card.lexicon.Word;

/**
 * Nouns that can refer to either an object or a player.
 */
public enum TargetNoun implements Word {
    THEM, THEY, WHO;

    @Override
    public String getWord() {
        return this.name();
    }
}
