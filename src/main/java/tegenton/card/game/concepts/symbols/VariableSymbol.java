package tegenton.card.game.concepts.symbols;

class VariableSymbol extends Symbol {
    private VariableSymbol() {
        super();
    }

    public static VariableSymbol fromString(String s) {
        if (s.equalsIgnoreCase("X")) {
            return new VariableSymbol();
        }
        return null;
    }
}
