package tegenton.card.game.concepts.symbols.level;

import tegenton.card.game.concepts.symbols.Symbol;
import tegenton.card.generic.Filter;
import java.util.List;
import java.util.function.Function;

public abstract class LevelSymbol extends Symbol {
    private static Filter<LevelSymbol> filter;

    private static void setupFilter() {
        final List<Function<String, LevelSymbol>> levelSymbols;
        levelSymbols = List.of(LevelRangeSymbol::fromString,
                LevelMinSymbol::fromString);
        filter = new Filter<>(levelSymbols);
    }

    /**
     * Determine if s represents a level symbol.
     *
     * @param s a string which might represent a level symbol, such as LEVEL 4+
     * @return the LevelSymbol object represented by s, or null if s does not
     * represent a level symbol
     */
    public static LevelSymbol fromString(final String s) {
        if (filter == null) {
            setupFilter();
        }
        return filter.filter(s);
    }
}
