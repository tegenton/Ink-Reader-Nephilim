package tegenton.card.parse.lexicon.game;

import tegenton.card.parse.lexicon.Word;

public enum Color implements Word {
    W, U, B, R, G, C;

    @Override
    public String getWord() {
        return this.name();
    }
}
