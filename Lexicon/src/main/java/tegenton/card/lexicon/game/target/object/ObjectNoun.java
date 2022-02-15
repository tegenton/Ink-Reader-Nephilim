package tegenton.card.lexicon.game.target.object;

import tegenton.card.lexicon.NounWord;
import tegenton.card.lexicon.game.target.TargetWord;

/**
 * Nouns referring to objects.
 */
public enum ObjectNoun implements TargetWord, NounWord {
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
