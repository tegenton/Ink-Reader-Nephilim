package tegenton.card.parse.lexicon.game.type;

import tegenton.card.parse.lexicon.Word;

public enum CounterName implements Word {
    CORPSE;

    @Override
    public String getWord() {
        return this.name();
    }
}
