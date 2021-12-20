package tegenton.card.parse.lexicon.game.turn;

import tegenton.card.parse.lexicon.Word;

public enum Chronology implements Word {
    AFTER, BEFORE, DURING;

    @Override
    public String getWord() {
        return this.name();
    }
}