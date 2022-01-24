package tegenton.card.parse.lexicon.game;

import tegenton.card.parse.lexicon.Word;

public enum Tap implements Word {
    T;

    @Override
    public String getWord() {
        return this.name();
    }
}
