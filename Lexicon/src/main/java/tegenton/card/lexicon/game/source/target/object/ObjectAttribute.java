package tegenton.card.lexicon.game.source.target.object;

import tegenton.card.lexicon.Word;

/**
 * Attributes of objects.
 */
public enum ObjectAttribute implements Word {
    FACE,
    LOYALTY,
    NAME,
    POWER,
    TOUGHNESS,
    VALUE;

    @Override
    public String toString() {
        return this.name();
    }
}
