package tegenton.card.parse.lexicon.game.turn;

import tegenton.card.parse.lexicon.Word;

public enum Duration implements Word {
    SINCE, UNTIL, WHILE;

    @Override
    public String getWord() {
        return this.name();
    }
}