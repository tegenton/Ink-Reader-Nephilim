package tegenton.card.parse.lexicon.game.type;

import tegenton.card.parse.lexicon.Word;

public enum LandType implements Word {
    PLAINS, ISLAND, SWAMP, MOUNTAIN, FOREST;

    @Override
    public String getWord() {
        return this.name();
    }
}
