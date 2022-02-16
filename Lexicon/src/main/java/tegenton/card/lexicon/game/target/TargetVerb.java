package tegenton.card.lexicon.game.target;

import tegenton.card.lexicon.VerbWord;

/**
 * Words representing actions of objects.
 */
public enum TargetVerb implements VerbWord {
    ASSIGN,
    GAIN,
    LOSE;

    @Override
    public String toString() {
        return this.name();
    }
}
