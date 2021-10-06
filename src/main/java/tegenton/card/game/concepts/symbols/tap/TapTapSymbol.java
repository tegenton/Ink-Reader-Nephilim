package tegenton.card.game.concepts.symbols.tap;

class TapTapSymbol extends TapSymbol {
    private TapTapSymbol() {
        super();
    }

    public static TapTapSymbol fromString(String s) {
        if (s.equalsIgnoreCase("T")) {
            return new TapTapSymbol();
        }
        return null;
    }
}
