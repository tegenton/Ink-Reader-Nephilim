package tegenton.card.game.concepts.symbols.tap;

final class UntapSymbol extends TapSymbol {
    private UntapSymbol() {
        super();
    }

    public static UntapSymbol fromString(final String s) {
        if (s.equalsIgnoreCase("Q")) {
            return new UntapSymbol();
        }
        return null;
    }
}
