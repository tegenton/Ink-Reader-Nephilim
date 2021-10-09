package tegenton.card.game.concepts.symbols.loyalty;

import tegenton.card.game.concepts.symbols.Symbol;
import tegenton.card.generic.Filter;

import java.util.List;
import java.util.function.Function;

public abstract class LoyaltySymbol extends Symbol {
    private static Filter<LoyaltySymbol> filter;

    private static void setupFilter() {
        List<Function<String, LoyaltySymbol>> loyaltySymbols;
        loyaltySymbols = List.of(StaticLoyaltySymbol::fromString,
                VariableLoyaltySymbol::fromString);
        filter = new Filter<>(loyaltySymbols);
    }

    public static LoyaltySymbol fromString(String s) {
        if (filter == null) {
            setupFilter();
        }
        return filter.filter(s);
    }
}
