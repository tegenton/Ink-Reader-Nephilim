package tegenton.card.parse.lexicon.type;

public enum SuperType implements Type {
    BASIC;

    @Override
    public String getWord() {
        return this.name();
    }
}
