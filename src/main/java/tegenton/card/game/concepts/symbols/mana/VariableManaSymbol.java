package tegenton.card.game.concepts.symbols.mana;

final class VariableManaSymbol extends ManaSymbol {
    private final int value = 0;

    private VariableManaSymbol() {
        super();
    }

    public static VariableManaSymbol fromString(final String s) {
        if (s.equalsIgnoreCase("X")) {
            return new VariableManaSymbol();
        }
        return null;
    }

    @Override
    public int getManaValue() {
        return value;
    }
}
