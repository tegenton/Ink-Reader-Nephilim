package tegenton.card.lexicon.game.source.target.object;

import tegenton.card.lexicon.Word;

/**
 * Adjectives that describe objects.
 */
public enum ObjectAdjective implements Word {
    TOP;

    @Override
    public String toString() {
        return this.name();
    }
}