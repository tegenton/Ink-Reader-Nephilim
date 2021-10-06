package tegenton.card.game.concepts.symbols.tap;

class UntapSymbol extends TapSymbol {
    private UntapSymbol() {
        super();
    }

    public static UntapSymbol fromString(String s) {
        if (s.equalsIgnoreCase("Q")) {
            return new UntapSymbol();
        }
        return null;
    }
}
