package tegenton.card.lexicon.game.source.target;

import tegenton.card.lexicon.Word;

/**
 * Words representing actions of objects.
 */
public enum TargetVerb implements Word {
    ASSIGN,
    GAIN,
    LOSE;

    @Override
    public String toString() {
        return this.name();
    }
}
