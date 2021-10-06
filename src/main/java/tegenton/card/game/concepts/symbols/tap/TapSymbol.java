package tegenton.card.game.concepts.symbols.tap;

import tegenton.card.game.concepts.symbols.Symbol;
import tegenton.card.generic.Filter;

import java.util.List;
import java.util.function.Function;

public abstract class TapSymbol extends Symbol {
    private static Filter<TapSymbol> filter;

    private static void setupFilter() {
        List<Function<String, TapSymbol>> tapSymbols;
        tapSymbols = List.of(TapTapSymbol::fromString, UntapSymbol::fromString);
        filter = new Filter<>(tapSymbols);
    }

    public static TapSymbol fromString(String s) {
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
