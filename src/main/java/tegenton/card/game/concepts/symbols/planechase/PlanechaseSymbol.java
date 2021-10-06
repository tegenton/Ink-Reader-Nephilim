package tegenton.card.game.concepts.symbols.planechase;

import tegenton.card.game.concepts.symbols.Symbol;
import tegenton.card.generic.Filter;

import java.util.List;
import java.util.function.Function;

public abstract class PlanechaseSymbol extends Symbol {
    private static Filter<PlanechaseSymbol> filter;

    private static void setupFilter() {
        List<Function<String, PlanechaseSymbol>> planechaseSymbols;
        planechaseSymbols = List.of(PlaneswalkSymbol::fromString, ChaosSymbol::fromString);
        filter = new Filter<>(planechaseSymbols);
    }

    public static PlanechaseSymbol fromString(String s) {
        if (filter == null) {
            setupFilter();
        }
        if (s.startsWith("{") && s.endsWith("}")) {
            s = removeBrackets(s);
            return filter.filter(s);
        }
        return null;
    }
}