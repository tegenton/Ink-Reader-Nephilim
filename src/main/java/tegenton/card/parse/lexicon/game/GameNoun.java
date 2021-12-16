package tegenton.card.parse.lexicon.game;

import tegenton.card.parse.lexicon.Word;

public enum GameNoun implements Word {
    ABILITY, COLOR, DAMAGE, EFFECT, GAME, LIFE, MANA, PILE, STEP, TURN, TYPE;

    @Override
    public String getWord() {
        return this.name();
    }
}
