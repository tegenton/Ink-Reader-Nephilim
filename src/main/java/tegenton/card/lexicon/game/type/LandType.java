package tegenton.card.lexicon.game.type;

import tegenton.card.lexicon.Word;

public enum LandType implements Word {
    PLAINS, ISLAND, SWAMP, MOUNTAIN, FOREST;

    @Override
    public String getWord() {
        return this.name();
    }
}
