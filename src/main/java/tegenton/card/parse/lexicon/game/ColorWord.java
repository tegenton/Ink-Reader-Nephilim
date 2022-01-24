package tegenton.card.parse.lexicon.game;

import tegenton.card.parse.lexicon.Word;

public enum ColorWord implements Word {
    WHITE, BLUE, BLACK, RED, GREEN;

    @Override
    public String getWord() {
        return this.name();
    }
}
