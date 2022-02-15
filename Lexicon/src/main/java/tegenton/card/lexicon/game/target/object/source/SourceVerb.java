package tegenton.card.lexicon.game.target.object.source;

import tegenton.card.lexicon.Verb;

/**
 * Words representing actions of a source.
 */
public enum SourceVerb implements Verb {
    DEAL,
    DO,
    PRODUCE,
    RESOLVE;

    @Override
    public String toString() {
        return this.name();
    }
}
