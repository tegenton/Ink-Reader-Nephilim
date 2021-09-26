package game.concepts.symbols.loyalty;

import game.concepts.symbols.Symbol;
import generic.Filter;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class LoyaltySymbol extends Symbol {
    private static Filter<Symbol> filter;

    private static void setupFilter() {
        List<Function<String, Optional<Symbol>>> loyaltySymbols;
        loyaltySymbols = List.of(StaticLoyaltySymbol::fromString, VariableLoyaltySymbol::fromString);
        filter = new Filter<>(loyaltySymbols);
    }

    public static Optional<Symbol> fromString(String s) {
        if (filter == null) {
            setupFilter();
        }
        return filter.filter(s);
    }
}
