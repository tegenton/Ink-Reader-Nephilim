package tegenton.card.game.concepts.symbols.mana;

class NumericManaSymbol extends ManaSymbol {
    // {0}, {1}, {2}, and so on
    private final int value;

    private NumericManaSymbol(int value) {
        super();
        this.value = value;
    }

    public static NumericManaSymbol fromString(String s) {
        NumericManaSymbol symbol;
        try {
            symbol = new NumericManaSymbol(Integer.parseInt(s));
        } catch (NumberFormatException n) {
            return null;
        }
        return symbol;
    }

    @Override
    public int getManaValue() {
        return value;
    }
}
