package tegenton.card.lexicon.game;

import tegenton.card.lexicon.Word;

/**
 * The colors are White, Blue, Black, Red, and Green.
 */
public enum ColorWord implements Word {
    WHITE,
    BLUE,
    BLACK,
    RED,
    GREEN;

    @Override
    public String toString() {
        return this.name();
    }
}
