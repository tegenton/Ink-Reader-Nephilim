package tegenton.card.game.concepts.symbols.mana;

final class NumericManaSymbol extends ManaSymbol {
    // {0}, {1}, {2}, and so on
    private final int value;

    private NumericManaSymbol(final int manaValue) {
        super();
        this.value = manaValue;
    }

    public static NumericManaSymbol fromString(final String s) {
        final NumericManaSymbol symbol;
        try {
            symbol = new NumericManaSymbol(Integer.parseInt(s));
        } catch (final NumberFormatException n) {
            return null;
        }
        return symbol;
    }

    @Override
    public int getManaValue() {
        return value;
    }
}
