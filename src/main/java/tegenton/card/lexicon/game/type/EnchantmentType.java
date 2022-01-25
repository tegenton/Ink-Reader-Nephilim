package tegenton.card.lexicon.game.type;

public enum EnchantmentType implements Type {
    AURA;

    @Override
    public String getWord() {
        return this.name();
    }
}
