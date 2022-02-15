package tegenton.card.lexicon.game;

import tegenton.card.lexicon.NounWord;

/**
 * Nouns representing game concepts.
 */
public enum GameNoun implements NounWord {
    ABILITY,
    COLOR,
    DAMAGE,
    EFFECT,
    GAME,
    LIFE,
    MANA,
    PILE,
    STEP,
    TURN,
    TYPE;

    @Override
    public String toString() {
        return this.name();
    }
}
