package tegenton.card.parse.lexicon.game.source.target.player;

import tegenton.card.parse.lexicon.Word;

public enum PlayerAdverb implements Word {
    CONTINUOUSLY;

    @Override
    public String getWord() {
        return this.name();
    }
}
