package tegenton.card.parse.lexicon.game.turn;

import tegenton.card.parse.lexicon.Word;

public enum Phase implements Word {
    BEGINNING, MAIN, COMBAT;

    @Override
    public String getWord() {
        return this.name();
    }
}
