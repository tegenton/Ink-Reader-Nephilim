package tegenton.card.parse.lexicon.game.type;

public enum CreatureType implements Type {
    GOBLIN, GOLEM, INSECT, MERFOLK, WALL, ZOMBIE;

    @Override
    public String getWord() {
        return this.name();
    }
}
