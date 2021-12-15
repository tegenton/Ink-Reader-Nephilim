package tegenton.card.parse.lexicon.source.something.player;

import tegenton.card.parse.lexicon.Word;

public enum PlayerNoun implements Word {
    OPPONENT,
    YOU;

    @Override
    public String getWord() {
        return this.name();
    }
}
