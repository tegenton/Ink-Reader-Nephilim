package tegenton.card.game.concepts.symbols.tap;

import tegenton.card.game.concepts.symbols.Symbol;
import tegenton.card.generic.Filter;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class TapSymbol extends Symbol {
    private static Filter<Symbol> filter;

    private static void setupFilter() {
        List<Function<String, Optional<Symbol>>> tapSymbols;
        tapSymbols = List.of(TapTapSymbol::fromString, UntapSymbol::fromString);
        filter = new Filter<>(tapSymbols);
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
