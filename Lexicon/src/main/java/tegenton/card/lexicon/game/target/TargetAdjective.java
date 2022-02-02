package tegenton.card.lexicon.game.target;

import tegenton.card.lexicon.Word;

/**
 * Adjectives that describe objects.
 */
public enum TargetAdjective implements Word {
    ABLE;

    @Override
    public String toString() {
        return this.name();
    }
}
