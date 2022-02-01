package tegenton.card.lexicon.game;

import tegenton.card.lexicon.Word;

/**
 * Nouns representing game concepts.
 */
public enum GameNoun implements Word {
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
