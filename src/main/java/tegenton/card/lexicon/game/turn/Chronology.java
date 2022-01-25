package tegenton.card.lexicon.game.turn;

import tegenton.card.lexicon.Word;

public enum Chronology implements Word {
    AFTER, BEFORE, DURING;

    @Override
    public String getWord() {
        return this.name();
    }
}
