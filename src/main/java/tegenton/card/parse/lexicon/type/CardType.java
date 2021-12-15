package tegenton.card.parse.lexicon.type;

public enum CardType implements Type {
    ARTIFACT,
    CREATURE,
    ENCHANTMENT,
    INSTANT,
    LAND,
    PLANESWALKER,
    SORCERY;

    @Override
    public String getWord() {
        return this.name();
    }
}
