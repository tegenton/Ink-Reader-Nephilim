package tegenton.card.lexicon.game.source.target.object;

import tegenton.card.lexicon.game.source.target.TargetWord;

/**
 * Nouns referring to objects.
 */
public enum ObjectNoun implements TargetWord {
    CARD,
    COPY,
    IT,
    PERMANENT,
    SPELL,
    TOKEN;

    @Override
    public String toString() {
        return this.name();
    }
}