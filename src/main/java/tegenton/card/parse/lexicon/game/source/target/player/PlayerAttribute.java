package tegenton.card.parse.lexicon.game.source.target.player;

import tegenton.card.parse.lexicon.Word;

public enum PlayerAttribute implements Word {
    SIZE, TOTAL;

    @Override
    public String getWord() {
        return this.name();
    }
}
