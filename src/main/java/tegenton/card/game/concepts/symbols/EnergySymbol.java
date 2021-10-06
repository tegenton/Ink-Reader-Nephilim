package tegenton.card.game.concepts.symbols;

class EnergySymbol extends Symbol {
    private EnergySymbol() {
        super();
    }

    public static EnergySymbol fromString(String s) {
        if (s.equalsIgnoreCase("{E}")) {
            return new EnergySymbol();
        }
        return null;
    }
}
