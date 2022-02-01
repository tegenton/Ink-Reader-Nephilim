package tegenton.card.lexicon.game.type;

public enum LandType implements TypeWord {
    PLAINS,
    ISLAND,
    SWAMP,
    MOUNTAIN,
    FOREST;

    @Override
    public String toString() {
        return this.name();
    }
}
