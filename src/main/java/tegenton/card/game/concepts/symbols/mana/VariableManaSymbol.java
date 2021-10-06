package tegenton.card.game.concepts.symbols.mana;

class VariableManaSymbol extends ManaSymbol {
    private int x = 0;

    private VariableManaSymbol() {
        super();
    }

    public static VariableManaSymbol fromString(String s) {
        if (s.equalsIgnoreCase("X")) {
            return new VariableManaSymbol();
        }
        return null;
    }

    @Override
    public int getManaValue() {
        return x;
    }
}
