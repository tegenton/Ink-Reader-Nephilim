package game.concepts.symbols.planechase;

import game.concepts.symbols.Symbol;

import java.util.Optional;

class PlaneswalkSymbol extends PlanechaseSymbol {
    private PlaneswalkSymbol() {
        super();
    }

    public static Optional<Symbol> fromString(String s) {
        if (s.equalsIgnoreCase("PW")) {
            return Optional.of(new PlaneswalkSymbol());
        }
        return Optional.empty();
    }
}
