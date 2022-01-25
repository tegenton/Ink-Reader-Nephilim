package tegenton.card.lexicon.game.source.target.player;

import tegenton.card.lexicon.Word;

public enum PlayerAdjective implements Word {
    ACTIVE, DEFENDING;

    @Override
    public String getWord() {
        return this.name();
    }
}
