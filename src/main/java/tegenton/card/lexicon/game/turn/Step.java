package tegenton.card.lexicon.game.turn;

import tegenton.card.lexicon.Word;

public enum Step implements Word {
    UPKEEP, END;

    @Override
    public String getWord() {
        return this.name();
    }
}
