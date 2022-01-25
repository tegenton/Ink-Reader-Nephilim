package tegenton.card.lexicon.game.turn;

import tegenton.card.lexicon.Word;

public enum Phase implements Word {
    BEGINNING, MAIN, COMBAT;

    @Override
    public String getWord() {
        return this.name();
    }
}
