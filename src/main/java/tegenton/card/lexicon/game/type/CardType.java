package tegenton.card.lexicon.game.type;

public enum CardType implements Type {
    ARTIFACT, CREATURE, ENCHANTMENT, INSTANT, LAND, PLANESWALKER, SORCERY;

    @Override
    public String getWord() {
        return this.name();
    }
}
