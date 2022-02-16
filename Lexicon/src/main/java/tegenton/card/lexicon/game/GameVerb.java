package tegenton.card.lexicon.game;

import tegenton.card.lexicon.VerbWord;

/**
 * Verbs representing actions not necessarily performed by a player or object.
 */
public enum GameVerb implements VerbWord {
    BE,
    CAUSE,
    FINISH,
    TOUCH;

    @Override
    public String toString() {
        return this.name();
    }
}
