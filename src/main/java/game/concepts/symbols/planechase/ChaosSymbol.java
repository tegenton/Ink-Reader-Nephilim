package game.concepts.symbols.planechase;

import game.concepts.symbols.Symbol;

import java.util.Optional;

class ChaosSymbol extends PlanechaseSymbol {
    private ChaosSymbol() {
        super();
    }

    public static Optional<Symbol> fromString(String s) {
        if (s.equalsIgnoreCase("CHAOS")) {
            return Optional.of(new ChaosSymbol());
        }
        return Optional.empty();
    }
}
