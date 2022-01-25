package tegenton.card.lexicon.game.turn;

import tegenton.card.lexicon.Word;

public enum Duration implements Word {
    SINCE, UNTIL, WHILE;

    @Override
    public String getWord() {
        return this.name();
    }
}
