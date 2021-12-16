package tegenton.card.parse.lexicon.game.source.target;

import tegenton.card.parse.lexicon.Word;

/**
 * Nouns that can refer to either an object or a player
 */
public enum TargetNoun implements Word {
    THEY;

    @Override
    public String getWord() {
        return this.name();
    }
}
