package tegenton.card.game.concepts.symbols.tap;

import tegenton.card.game.concepts.symbols.Symbol;
import tegenton.card.generic.Filter;
import java.util.List;
import java.util.function.Function;

public abstract class TapSymbol extends Symbol {
    private static Filter<TapSymbol> filter;

    private static void setupFilter() {
        final List<Function<String, TapSymbol>> tapSymbols;
        tapSymbols = List.of(TapTapSymbol::fromString, UntapSymbol::fromString);
        filter = new Filter<>(tapSymbols);
    }

    /**
     * Determine if s represents a tap symbol.
     *
     * @param s a string which might represent a tap symbol,
     *          such as {Q}
     * @return the TapSymbol object represented by s,
     * or null if s does not represent a tap symbol
     */
    public static TapSymbol fromString(final String s) {
        if (filter == null) {
            setupFilter();
        }
        if (s.startsWith("{") && s.endsWith("}")) {
            return filter.filter(removeBrackets(s));
        }
        return null;
    }
}
