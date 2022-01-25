package tegenton.card.lexicon.game;

import tegenton.card.lexicon.Word;

public enum ColorWord implements Word {
    WHITE, BLUE, BLACK, RED, GREEN;

    @Override
    public String getWord() {
        return this.name();
    }
}
