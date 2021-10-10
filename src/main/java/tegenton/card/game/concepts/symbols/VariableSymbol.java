package tegenton.card.game.concepts.symbols;

final class VariableSymbol extends Symbol {
    private VariableSymbol() {
        super();
    }

    public static VariableSymbol fromString(final String s) {
        if (s.equalsIgnoreCase("X")) {
            return new VariableSymbol();
        }
        return null;
    }
}
