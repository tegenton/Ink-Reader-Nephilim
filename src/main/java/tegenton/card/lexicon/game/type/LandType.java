package tegenton.card.lexicon.game.type;

public enum LandType implements Type {
    PLAINS, ISLAND, SWAMP, MOUNTAIN, FOREST;

    @Override
    public String getWord() {
        return this.name();
    }
}
