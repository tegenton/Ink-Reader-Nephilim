package tegenton.card.lexicon.game.source.target;

import tegenton.card.lexicon.Word;

/**
 * A category of verb adding additional meaning.
 */
public enum TargetAuxiliaryVerb implements Word {
    CAN,
    WOULD;

    @Override
    public String toString() {
        return this.name();
    }
}
