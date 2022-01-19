package tegenton.card.parse.lexicon.game;

import tegenton.card.parse.lexicon.Word;

public enum Zone implements Word {
    ANTE, BATTLEFIELD, DECK, EXILE, GRAVEYARD, HAND, LIBRARY;

    @Override
    public String getWord() {
        return this.name();
    }
}
