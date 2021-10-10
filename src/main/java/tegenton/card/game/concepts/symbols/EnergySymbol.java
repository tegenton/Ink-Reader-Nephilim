package tegenton.card.game.concepts.symbols;

final class EnergySymbol extends Symbol {
    private EnergySymbol() {
        super();
    }

    public static EnergySymbol fromString(final String s) {
        if (s.equalsIgnoreCase("{E}")) {
            return new EnergySymbol();
        }
        return null;
    }
}
