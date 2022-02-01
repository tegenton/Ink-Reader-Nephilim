package tegenton.card.lexicon.game.source;

import tegenton.card.lexicon.Word;

/**
 * Words representing actions of a source.
 */
public enum SourceVerb implements Word {
    DEAL,
    DO,
    PRODUCE,
    RESOLVE;

    @Override
    public String toString() {
        return this.name();
    }
}
