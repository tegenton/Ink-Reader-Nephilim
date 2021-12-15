package tegenton.card.parse.lexicon.source.player;

import tegenton.card.parse.lexicon.Word;

public enum PlayerNoun implements Word {
    OPPONENT,
    THEY,
    YOU;

    @Override
    public String getWord() {
        return this.name();
    }
}
