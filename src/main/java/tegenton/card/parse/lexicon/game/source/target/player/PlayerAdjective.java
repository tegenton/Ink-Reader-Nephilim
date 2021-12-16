package tegenton.card.parse.lexicon.game.source.target.player;

import tegenton.card.parse.lexicon.Word;

public enum PlayerAdjective implements Word {
    ACTIVE;

    @Override
    public String getWord() {
        return this.name();
    }
}
