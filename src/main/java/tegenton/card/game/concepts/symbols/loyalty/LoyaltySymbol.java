package tegenton.card.game.concepts.symbols.loyalty;

import tegenton.card.game.concepts.symbols.Symbol;
import tegenton.card.generic.Filter;
import java.util.List;
import java.util.function.Function;

public abstract class LoyaltySymbol extends Symbol {
    private static Filter<LoyaltySymbol> filter;

    private static void setupFilter() {
        final List<Function<String, LoyaltySymbol>> loyaltySymbols;
        loyaltySymbols = List.of(StaticLoyaltySymbol::fromString,
                VariableLoyaltySymbol::fromString);
        filter = new Filter<>(loyaltySymbols);
    }

    /**
     * Determine if s represents a loyalty symbol.
     *
     * @param s a string which might represent a loyalty symbol, such as {W}
     * @return the LoyaltySymbol object represented by s, or null if s does not
     * represent a loyalty symbol
     */
    public static LoyaltySymbol fromString(final String s) {
        if (filter == null) {
            setupFilter();
        }
        return filter.filter(s);
    }
}
