package tegenton.card.parse.lexicon.game.turn;

import tegenton.card.parse.lexicon.Word;

public enum Step implements Word {
    UPKEEP, END;

    @Override
    public String getWord() {
        return this.name();
    }
}
