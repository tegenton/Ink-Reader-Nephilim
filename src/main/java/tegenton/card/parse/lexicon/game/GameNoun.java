package tegenton.card.parse.lexicon.game;

import tegenton.card.parse.lexicon.Word;

public enum GameNoun implements Word {
    ABILITY, DAMAGE, EFFECT, GAME, LIFE, PILE, STEP, TURN;

    @Override
    public String getWord() {
        return this.name();
    }
}
