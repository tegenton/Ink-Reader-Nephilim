package tegenton.card.game.concepts.symbols.mana;

final class SnowManaSymbol extends ManaSymbol {
    private SnowManaSymbol() {
        super();
    }

    public static SnowManaSymbol fromString(final String s) {
        if (s.equalsIgnoreCase("S")) {
            return new SnowManaSymbol();
        }
        return null;
    }

}
