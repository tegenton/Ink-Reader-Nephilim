package game.concepts.symbols.planechase;

import game.concepts.symbols.Symbol;
import generic.Filter;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class PlanechaseSymbol extends Symbol {
    private static Filter<Symbol> filter;

    private static void setupFilter() {
        List<Function<String, Optional<Symbol>>> planechaseSymbols;
        planechaseSymbols = List.of(PlaneswalkSymbol::fromString, ChaosSymbol::fromString);
        filter = new Filter<>(planechaseSymbols);
    }

    public static Optional<Symbol> fromString(String s) {
        if (filter == null) {
            setupFilter();
        }
        if (s.startsWith("{") && s.endsWith("}")) {
            s = removeBrackets(s);
            return filter.filter(s);
        }
        return Optional.empty();
    }
}