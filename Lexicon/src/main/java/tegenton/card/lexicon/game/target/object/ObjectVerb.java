package tegenton.card.lexicon.game.target.object;

import tegenton.card.lexicon.Verb;

/**
 * Words describing the actions of objects.
 */
public enum ObjectVerb implements Verb {
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
