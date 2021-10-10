package tegenton.card.game.concepts.symbols.tap;

final class TapTapSymbol extends TapSymbol {
    private TapTapSymbol() {
        super();
    }

    public static TapTapSymbol fromString(final String s) {
        if (s.equalsIgnoreCase("T")) {
            return new TapTapSymbol();
        }
        return null;
    }
}
