package tegenton.card.lexicon.game;

import tegenton.card.lexicon.Word;

public enum Tap implements Word {
    T;

    @Override
    public String getWord() {
        return this.name();
    }
}
