package tegenton.card.game.concepts.symbols.level;

import tegenton.card.game.concepts.symbols.Symbol;
import tegenton.card.generic.Filter;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class LevelSymbol extends Symbol {
    private static Filter<Symbol> filter;

    private static void setupFilter() {
        List<Function<String, Optional<Symbol>>> levelSymbols;
        levelSymbols = List.of(LevelRangeSymbol::fromString, LevelMinSymbol::fromString);
        filter = new Filter<>(levelSymbols);
    }

    public static Optional<Symbol> fromString(String s) {
        if (filter == null) {
            setupFilter();
        }
        return filter.filter(s);
    }
}
