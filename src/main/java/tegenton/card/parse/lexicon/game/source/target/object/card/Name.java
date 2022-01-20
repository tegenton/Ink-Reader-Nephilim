package tegenton.card.parse.lexicon.game.source.target.object.card;

import tegenton.card.parse.lexicon.Word;

public enum Name implements Word {
    PLAGUE,
    RATS;

    @Override
    public String getWord() {
        return this.name();
    }
}
