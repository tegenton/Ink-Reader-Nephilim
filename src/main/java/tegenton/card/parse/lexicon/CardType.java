package tegenton.card.parse.lexicon;

public enum CardType implements Type {
    CREATURE,
    LAND,
    ARTIFACT,
    ENCHANTMENT,
    INSTANT,
    SORCERY,
    PLANESWALKER;

    @Override
    public String getWord() {
        return this.name();
    }
}
