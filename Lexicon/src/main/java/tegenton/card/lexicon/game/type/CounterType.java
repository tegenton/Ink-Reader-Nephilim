package tegenton.card.lexicon.game.type;

import tegenton.card.lexicon.Word;

public enum CounterType implements Word {
    CORPSE,
    MIRE,
    VITALITY;

    @Override
    public String toString() {
        return this.name();
    }
}
