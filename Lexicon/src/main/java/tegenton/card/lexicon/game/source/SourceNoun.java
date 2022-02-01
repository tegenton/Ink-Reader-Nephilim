package tegenton.card.lexicon.game.source;

import tegenton.card.lexicon.Word;

/**
 * Words that refer to sources.
 */
public enum SourceNoun implements Word {
    SOURCE;

    @Override
    public String toString() {
        return this.name();
    }
}
