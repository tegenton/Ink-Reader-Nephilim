package tegenton.card.parse.lexicon.game.source.target.object.card;

import tegenton.card.parse.lexicon.Word;

public enum CardName implements Word {
    PLAGUE,
    RATS,
    WASP;

    @Override
    public String getWord() {
        return this.name();
    }
}
