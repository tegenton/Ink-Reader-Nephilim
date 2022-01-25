package tegenton.card.lexicon.game.source.target.player;

import tegenton.card.lexicon.Word;

public enum PlayerAttribute implements Word {
    MAXIMUM, SIZE, TOTAL;

    @Override
    public String getWord() {
        return this.name();
    }
}
