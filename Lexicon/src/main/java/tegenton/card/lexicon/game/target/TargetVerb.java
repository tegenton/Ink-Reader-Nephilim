package tegenton.card.lexicon.game.target;

import tegenton.card.lexicon.Verb;

/**
 * Words representing actions of objects.
 */
public enum TargetVerb implements Verb {
    ASSIGN,
    GAIN,
    LOSE;

    @Override
    public String toString() {
        return this.name();
    }
}
