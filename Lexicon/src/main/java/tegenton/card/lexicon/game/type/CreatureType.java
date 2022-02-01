package tegenton.card.lexicon.game.type;

public enum CreatureType implements TypeWord {
    GOBLIN,
    GOLEM,
    INSECT,
    MERFOLK,
    WALL,
    ZOMBIE;

    @Override
    public String toString() {
        return this.name();
    }
}
