package tegenton.card.lexicon.game.target.object;

import tegenton.card.lexicon.VerbWord;

/**
 * Words describing the actions of objects.
 */
public enum ObjectVerb implements VerbWord {
    ATTACK,
    BECOME,
    BLOCK,
    COST,
    DIE,
    ENTER,
    GET,
    HAVE,
    IS,
    LEAVE,
    TAP;

    @Override
    public String toString() {
        return this.name();
    }
}
