package tegenton.card.lexicon.game;

import tegenton.card.lexicon.Word;

public enum Color implements Word {
    W, U, B, R, G, C;

    @Override
    public String getWord() {
        return this.name();
    }
}
