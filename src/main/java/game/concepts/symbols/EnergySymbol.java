package game.concepts.symbols;

import java.util.Optional;

class EnergySymbol extends Symbol {
    private EnergySymbol() {
        super();
    }

    public static Optional<Symbol> fromString(String s) {
        if (s.equalsIgnoreCase("{E}")) {
            return Optional.of(new EnergySymbol());
        }
        return Optional.empty();
    }
}
