package tegenton.card.lexicon.game.source.target.object.card;

import tegenton.card.lexicon.Word;

public enum CardName implements Word {
    PLAGUE,
    RATS,
    WASP;

    @Override
    public String getWord() {
        return this.name();
    }
}
