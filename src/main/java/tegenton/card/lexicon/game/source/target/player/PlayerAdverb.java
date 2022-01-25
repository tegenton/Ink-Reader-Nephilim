package tegenton.card.lexicon.game.source.target.player;

import tegenton.card.lexicon.Word;

public enum PlayerAdverb implements Word {
    CONTINUOUSLY;

    @Override
    public String getWord() {
        return this.name();
    }
}
