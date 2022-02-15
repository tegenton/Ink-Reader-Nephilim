package tegenton.card.lexicon.game.target.object.source;

import tegenton.card.lexicon.VerbWord;

/**
 * Words representing actions of a source.
 */
public enum SourceVerb implements VerbWord {
    DEAL,
    DO,
    PRODUCE,
    RESOLVE;

    @Override
    public String toString() {
        return this.name();
    }
}
