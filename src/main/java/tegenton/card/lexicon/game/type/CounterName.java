package tegenton.card.lexicon.game.type;

import tegenton.card.lexicon.Word;

public enum CounterName implements Word {
    CORPSE, MIRE, VITALITY;

    @Override
    public String getWord() {
        return this.name();
    }
}
