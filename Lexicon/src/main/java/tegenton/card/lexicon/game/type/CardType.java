package tegenton.card.lexicon.game.type;

/**
 * Card types determine the base rules of how a card behaves.
 */
public enum CardType implements TypeWord {
    ARTIFACT,
    CREATURE,
    ENCHANTMENT,
    INSTANT,
    LAND,
    PLANESWALKER,
    SORCERY;

    @Override
    public String toString() {
        return this.name();
    }
}
