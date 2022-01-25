package tegenton.card.lexicon.game.type;

public enum SuperType implements Type {
    BASIC;

    @Override
    public String getWord() {
        return this.name();
    }
}
