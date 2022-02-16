package tegenton.card.lexicon.value;

import tegenton.card.lexicon.game.CostSymbol;

public enum Variable implements ValueWord, CostSymbol {
    X,
    Y;

    @Override
    public int getValue() {
        return 0;
    }
}
