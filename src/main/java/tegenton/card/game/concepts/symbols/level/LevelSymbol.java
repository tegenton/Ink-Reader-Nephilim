package tegenton.card.game.concepts.symbols.level;

import tegenton.card.game.concepts.symbols.Symbol;
import tegenton.card.generic.Filter;

import java.util.List;
import java.util.function.Function;

public abstract class LevelSymbol extends Symbol {
    private static Filter<LevelSymbol> filter;

    private static void setupFilter() {
        List<Function<String, LevelSymbol>> levelSymbols;
        levelSymbols = List.of(LevelRangeSymbol::fromString, LevelMinSymbol::fromString);
        filter = new Filter<>(levelSymbols);
    }

    public static LevelSymbol fromString(String s) {
        if (filter == null) {
            setupFilter();
        }
        return filter.filter(s);
    }
}
