package tegenton.card.lexicon.game.source.target.object;

import tegenton.card.lexicon.Word;

/**
 * Words describing the actions of objects.
 */
public enum ObjectVerb implements Word {
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
