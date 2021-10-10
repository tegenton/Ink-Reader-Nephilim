package tegenton.card.game.concepts.symbols.planechase;

import tegenton.card.game.concepts.symbols.Symbol;
import tegenton.card.generic.Filter;
import java.util.List;
import java.util.function.Function;

/**
 * The Planechase symbols are {PW} and {CHAOS}.
 */
public abstract class PlanechaseSymbol extends Symbol {
    private static Filter<PlanechaseSymbol> filter;

    private static void setupFilter() {
        final List<Function<String, PlanechaseSymbol>> planechaseSymbols;
        planechaseSymbols = List.of(PlaneswalkSymbol::fromString,
                ChaosSymbol::fromString);
        filter = new Filter<>(planechaseSymbols);
    }

    /**
     * Determine if s represents a planechase symbol.
     *
     * @param s a string which might represent a planechase symbol,
     *          such as {CHAOS}
     * @return the PlanechaseSymbol object represented by s,
     * or null if s does not represent a planechase symbol
     */
    public static PlanechaseSymbol fromString(final String s) {
        if (filter == null) {
            setupFilter();
        }
        if (s.startsWith("{") && s.endsWith("}")) {
            return filter.filter(removeBrackets(s));
        }
        return null;
    }
}
